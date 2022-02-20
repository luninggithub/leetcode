package com.baidu.duershow.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution1212 {

    /**
     * https://leetcode-cn.com/problems/spiral-matrix-ii/
     *
     * 59. 螺旋矩阵 II
     * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int val = 1;
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        while (left <= right && top <= bottom) {
            for (int column  = left; column <= right; column ++) {
                result[top][column] = val;
                val++;
            }
            for (int row = top + 1; row <= bottom; row ++) {
                result[row][right] = val;
                val ++;
            }

            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column --) {
                    result[bottom][column] = val;
                    val ++;
                }

                for (int row = bottom; row > top; row --) {
                    result[row][left] = val;
                    val ++;
                }
            }
            left ++;
            right --;
            top ++;
            bottom --;
        }
        return result;
    }

    /**
     * https://leetcode-cn.com/problems/rotate-list/
     *
     * 61. 旋转链表
     * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        int len = 1;
        while (current.next != null) {
            current = current.next;
            len ++;
        }
        int mod = k % len;
        if (mod == 0) {
            return head;
        }
        int add = len - mod;
        current.next = head;
        while (add > 0) {
            current = current.next;
            add --;
        }
        head = current.next;
        current.next = null;
        return head;
    }


    /**
     * https://leetcode-cn.com/problems/unique-paths/
     *
     * 62. 不同路径
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            res[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            res[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] = res[i-1][j] + res[i][j - 1];
            }
        }
        return res[m - 1][n - 1];
    }
    public int uniquePaths2(int m, int n) {
        if (m == 1 && n == 1) {
            return 1;
        }
        if (m == 1) {
            return uniquePaths2(1, n - 1);
        }
        if (n == 1) {
            return uniquePaths2(m - 1, 1);
        }
        return uniquePaths2(m-1, n) + uniquePaths2(m, n-1);
    }


    /**
     * https://leetcode-cn.com/problems/subsets/
     *
     * 78. 子集
     *
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> initSub = new ArrayList<>();
        res.add(initSub);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int time = res.size();
            for (int j = 0; j < time; j++) {
                List<Integer> list = res.get(j);
                List<Integer> sub = new ArrayList<>(list);
                sub.add(num);
                res.add(sub);
            }
        }
        return res;
    }
}
