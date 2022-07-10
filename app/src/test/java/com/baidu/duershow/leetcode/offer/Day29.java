package com.baidu.duershow.leetcode.offer;

import java.util.Arrays;

public class Day29 {

    /**
     * https://leetcode.cn/problems/chou-shu-lcof/
     * 剑指 Offer 49. 丑数
     * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第n个丑数。
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        // 索引a, b, c，分别记录前几个数已经被乘2， 乘3， 乘5了，比如a表示前(a-1)个数都已经乘过一次2了
        int a = 0;
        int b = 0;
        int c= 0;
        for (int i = 1; i < n; i++) {
            int na = dp[a] * 2;
            int nb = dp[b] * 3;
            int nc = dp[c] * 5;
            dp[i] = Math.min(na, Math.min(nb, nc));
            if (dp[i] == na) {
                a ++;
            }
            if (dp[i] == nb) {
                b ++;
            }
            if (dp[i] == nc) {
                c ++;
            }
        }
        return dp[n-1];
    }

    /**
     * https://leetcode.cn/problems/nge-tou-zi-de-dian-shu-lcof/
     * 剑指 Offer 60. n个骰子的点数
     * @param n
     * @return
     */
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            // 每次的点数之和范围会有点变化，点数之和的值最大是i*6，最小是i*1，i之前的结果值是不会出现的；
            // 比如i=3个骰子时，最小就是3了，不可能是2和1，所以点数之和的值的个数是6*i-(i-1)，化简：5*i+1
            double[] temp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j ++) {
                for (int k = 0; k < 6; k ++) {
                    temp[j + k] += dp[j] * (1.0 / 6.0);
                }
            }
            dp = temp;
        }
        return dp;
    }

}
