package com.baidu.duershow.leetcode.offer;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Day27 {
    @Test
    public void addition_isCorrect() {
        int[] test = new int[] {1,3,-1,-3,5,3,6,7};
        maxSlidingWindow(test, 3);
    }

    /**
     * https://leetcode.cn/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
     * 剑指 Offer 59 - I. 滑动窗口的最大值
     * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
     * @param nums [1,3,-1,-3,5,3,6,7]
     * @param k 3
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        // 设置辅助队列，将最大值放在头部
        for (int i = 1 - k, j = 0; j < nums.length; i++, j++) {
            if (i >= 1 && deque.peekFirst() == nums[i-1]) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.removeLast();
            }
            deque.addLast(nums[j]);
            if (i >= 0) {
                res[i] = deque.peekFirst();
            }
        }
        return res;
    }

    class MaxQueue {
        Queue<Integer> all = new LinkedList<>();
        Deque<Integer> deq = new LinkedList<>();
        public MaxQueue() {

        }

        public int max_value() {
            if (all.size() <= 0) {
                return -1;
            }
            return deq.peekFirst();
        }

        public void push_back(int value) {
            while (!deq.isEmpty() && deq.peekLast() < value) {
                deq.removeLast();
            }
            deq.addLast(value);
            all.add(value);
        }

        public int pop_front() {
            if (all.size() <= 0) {
                return -1;
            }
            int a = all.poll();
            if (a == deq.peekFirst()) {
                return deq.pollFirst();
            }
            return a;
        }
    }
}
