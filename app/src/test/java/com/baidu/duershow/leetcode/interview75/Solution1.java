package com.baidu.duershow.leetcode.interview75;

/**
 * https://leetcode.cn/problems/ti-huan-kong-ge-lcof/?envType=study-plan-v2&envId=coding-interviews
 * LCR 122. 路径加密
 */
public class Solution1 {

    public String pathEncryption1(String path) {
        return path.replace(".", " ");
    }

    public String pathEncryption2(String path) {
        StringBuilder res = new StringBuilder();
        for (Character c : path.toCharArray()) {
            if (c == '.') {
                res.append(' ');
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
