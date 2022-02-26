package com.baidu.duershow.leetcode.offer;

public class Day3 {
    /**
     * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
     * 剑指 Offer 05. 替换空格
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char val : chars) {
            if (val == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(val);
            }
        }
        return stringBuilder.toString();
    }


    /**
     * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
     * 剑指 Offer 58 - II. 左旋转字符串
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
     * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，
     * 该函数将返回左旋转两位得到的结果"cdefgab"。
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        String left = s.substring(0, n);
        s = s.substring(n);
        s = s + left;
        return s;
    }
}
