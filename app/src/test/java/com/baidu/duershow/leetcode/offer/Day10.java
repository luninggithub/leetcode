package com.baidu.duershow.leetcode.offer;

public class Day10 {

    /**
     * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
     * 剑指 Offer 46. 把数字翻译成字符串
     * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，
     * 25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     * @param num
     * @return
     */
    public int translateNum(int num) {
        String nums = String.valueOf(num);
        int a1 = 1;
        int a2 = 1;
        for (int i = 2; i <= nums.length(); i++) {
            String sub = nums.substring(i-2, i);
            int c = a1;
            if (sub.compareTo("10") >= 0 && sub.compareTo("25") <= 0) {
                c = a1 + a2;
            }
            a2 = a1;
            a1 = c;
        }
        return a1;
    }
}
