package com.baidu.duershow.leetcode.offer;

public class Day21 {
    /**
     * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
     * 剑指 Offer 15. 二进制中1的个数
     * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数
     * （也被称为 汉明重量).）。
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    /**
     * https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
     * 剑指 Offer 65. 不用加减乘除做加法
     * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }
}
