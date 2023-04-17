package com.baidu.duershow.leetcode.offer2;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class Day1 {
    @Test
    public void addition_isCorrect() {
    }

    /**
     * 剑指 Offer 09. 用两个栈实现队列
     * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
     * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
     *
     * 链接：https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
     */
    class CQueue {

        // 关键之处：
        // 栈（先进后出）正常出栈是顶部元素（尾部），无法实现队列的删除头部，需要两个栈：
        // stack1正常进栈实现队列插入；
        // stack2转存stack1的出栈数据，刚好是倒序，可以实现队列的删除头部
        private LinkedList<Integer> stack1;
        private LinkedList<Integer> stack2;

        public CQueue() {
            stack1 = new LinkedList<>();
            stack2 = new LinkedList<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (!stack2.isEmpty()) {
                return stack2.pop();
            } else if (stack1.isEmpty()) {
                return -1;
            } else {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
                return stack2.pop();
            }
        }
    }

    /**
     * 剑指 Offer 30. 包含min函数的栈
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
     */
    class MinStack {

        // 关键之处：min的时间复杂度要求为O(1)
        // stack1存储原始数据，push、pop、top可直接用stack实现，比较简单
        // stack2维护一个降序栈，每次插入的时候做一次比较，小于当前顶部才入栈，这样顶部保持最小；
        // 由于stack2会在stack1每次入栈的时候做一次比较，因此，stack2存储着stack1栈所有状态下的最小值。
        // 每次出栈时对stack2做一次处理，看出栈的原始是否在stack2顶部即可，若是，则一起出栈。出栈后stack2中顶部依旧是最小值
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        /** initialize your data structure here. */
        public MinStack() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
            if (stack2.isEmpty() || stack2.peek() >= x) {
                stack2.push(x);
            }
        }

        public void pop() {
            if (stack1.pop().equals(stack2.peek())) {
                stack2.pop();
            }
        }

        public int top() {
            return stack1.peek();
        }

        public int min() {
            return stack2.peek();
        }
    }
}