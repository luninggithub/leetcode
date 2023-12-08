package com.baidu.duershow.leetcode.interview75;

public class Solution4 {
    public int my(String s) {
        char[] chars = s.trim().toCharArray();
        if (chars.length == 0) {
            return 0;
        }
        int sign = 1;
        int index = 0;
        int bundry = Integer.MAX_VALUE / 10;
        if (chars[0] == '-') {
            sign = -1;
            index = 1;
        } else if (chars[0] == '+') {
            index = 1;
        }
        int result = 0;
        for (int i = index; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                break;
            }
            if (result > bundry || result == bundry && chars[i] > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + (chars[i] - '0');
        }
        return result * sign;
    }
}
