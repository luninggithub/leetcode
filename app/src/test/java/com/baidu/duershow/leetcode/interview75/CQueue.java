package com.baidu.duershow.leetcode.interview75;

import java.util.Stack;

/**
 *
 */
public class CQueue {

    private Stack<Integer> stackA;
    private Stack<Integer> stackB;

    public CQueue() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }

    public void appendTail(int value) {
        stackA.push(value);
    }

    public int deleteHead() {
        if (!stackB.empty()) {
            return stackB.pop();
        } else if (!stackA.empty()){
            while (!stackA.empty()) {
                stackB.push(stackA.pop());
            }
            return stackB.pop();
        }
        return -1;
    }
}
