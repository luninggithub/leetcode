package com.baidu.duershow.leetcode.offer;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Day25 {

    /**
     * https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
     * 剑指 Offer 29. 顺时针打印矩阵
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int left = 0;
        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int[] res = new int[matrix.length * matrix[0].length];
        int index = 0;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                res[index] = matrix[top][i];
                index ++;
            }
            for (int j = top + 1; j <= bottom; j++) {
                res[index] = matrix[j][right];
                index ++;
            }
            if (left < right && top < bottom) {
                for (int i = right - 1; i > left; i --) {
                    res[index] = matrix[bottom][i];
                    index ++;
                }
                for (int j = bottom; j > top; j --) {
                    res[index] = matrix[j][left];
                    index ++;
                }
            }
            left ++;
            right --;
            top ++;
            bottom --;
        }
        return res;
    }


    /**
     * https://leetcode.cn/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
     * 剑指 Offer 31. 栈的压入、弹出序列
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i : pushed) {
            stack.push(i);
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index ++;
            }
        }
        return stack.isEmpty();
    }
}
