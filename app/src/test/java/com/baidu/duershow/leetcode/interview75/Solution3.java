package com.baidu.duershow.leetcode.interview75;

public class Solution3 {

    public boolean a(String s) {
        char[] chars = s.trim().toCharArray();
        boolean isNumber = false;
        boolean isDot = false;
        boolean isE_or_e = false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                isNumber = true;
            } else if (chars[i] == '.') {
                if (isDot || isE_or_e) {
                    return false;
                }
                isDot = true;
            } else if (chars[i] == 'e' || chars[i] == 'E') {
                if (isE_or_e || !isNumber) {
                    return false;
                }
                isE_or_e = true;
                isNumber = false;
            } else if (chars[i] == '+' || chars[i] == '-') {
                if (i != 0 && chars[i-1] != 'e' && chars[i-1] != 'E') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return isNumber;
    }

}
