package com.baidu.duershow.leetcode.offer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Day24 {

    /**
     * https://leetcode.cn/problems/jian-sheng-zi-lcof/
     * 剑指 Offer 14- I. 剪绳子
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        // dp[i]代表长度为i的绳子剪出的最大乘机
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(Math.max(j*(i-j), j*dp[i-j]), dp[i]);
            }
        }
        return dp[n];
    }


    /**
     * https://leetcode.cn/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
     * 剑指 Offer 57 - II. 和为s的连续正数序列
     * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）
     * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        // 滑动窗口，左开右闭
        int left = 1;
        int right = 1;
        int sum = 0;
        List<int[]> res = new LinkedList<>();
        while (left <= target / 2) {
            if (sum < target) {
                sum = sum + right;
                right ++;
            } else if (sum > target) {
                sum = sum - left;
                left ++;
            } else {
                int[] arr = new int[right - left];
                for (int i = left; i < right; i++) {
                    arr[i-left] = i;
                }
                res.add(arr);
                sum = sum - left;
                left ++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    /**
     * https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
     * 剑指 Offer 62. 圆圈中最后剩下的数字
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        // 总结一下反推的过程，就是 (当前index + m) % 上一轮剩余数字的个数
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

}
