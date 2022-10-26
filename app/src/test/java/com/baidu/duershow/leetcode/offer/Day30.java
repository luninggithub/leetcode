package com.baidu.duershow.leetcode.offer;

public class Day30 {

    /**
     * https://leetcode.cn/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
     * 剑指 Offer 17. 打印从1到最大的n位数
     * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999
     * @param n
     * @return
     */
    public int[] printNumbers(int n) {
        int end = (int)Math.pow(10, n) - 1;
        int[] res = new int[end];
        for(int i = 0; i < end; i++) {
            res[i] = i + 1;
        }
        return res;
    }


    /**
     * TODO 不排除大数
     * @param n
     * @return
     */
    public String[] printNumbers2(int n) {
        return null;
    }

}
