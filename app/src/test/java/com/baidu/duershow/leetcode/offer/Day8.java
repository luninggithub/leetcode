
package com.baidu.duershow.leetcode.offer;

public class Day8 {

    /**
     * 剑指 Offer 10- II. 青蛙跳台阶问题
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     *
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     * @param n
     * @return
     */
    public int numWays2(int n) {
        if (n <= 1) {
            return 1;
        }
        int a = 1;
        int b = 1;
        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return sum;
    }

    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return numWays(n-1) + numWays(n-2);
    }

    /**
     * https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
     * 剑指 Offer 63. 股票的最大利润
     * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}
