package com.baidu.duershow.leetcode.interview75;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/?envType=study-plan-v2&envId=coding-interviews
 * LCR 182. 动态口令
 */
public class Solution2 {
    public String dynamicPassword1(String password, int target) {
        String prefix = password.substring(0, target);
        return password.substring(target) + prefix;
    }

    /**
     * 前面移到后面以后，顺序相反
     * @param password
     * @param target
     * @return
     */
    public String dynamicPassword2(String password, int target) {
        char[] res = password.toCharArray();
        int count = 0;
        while (count < target) {
            char temp = res[0];
            for (int i = 0; i < res.length - 1; i++) {
                res[i] = res[i + 1];
            }
            res[res.length-1] = temp;
            count ++;
        }
        return Arrays.toString(res);
    }

}
