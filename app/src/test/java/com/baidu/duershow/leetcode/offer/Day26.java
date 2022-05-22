package com.baidu.duershow.leetcode.offer;

import java.util.regex.Pattern;

public class Day26 {

    /**
     * https://leetcode.cn/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
     * 剑指 Offer 20. 表示数值的字符串
     * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）
     */
    public boolean isNumber(String s) {
        s = s.trim();
        Pattern pattern = Pattern.compile("^([+\\-])?(\\d+(\\.\\d*)?|\\.\\d+)(([eE])([+\\-])?\\d+)?$");
        return pattern.matcher(s).matches();
    }

    public boolean isNumber2(String s) {
        if (s == null || s.length() == 0) return false;
        //去掉首位空格
        s = s.trim();
        //是否出现数字
        boolean numFlag = false;
        //是否出现小数点
        boolean dotFlag = false;
        boolean eFlag = false;
        for (int i = 0; i < s.length(); i++) {
            //判定为数字，则标记numFlag
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numFlag = true;
                //小数点只可以出现再e之前，且只能出现一次.num  num.num num.都是被允许的
            } else if (s.charAt(i) == '.' && !dotFlag && !eFlag) {
                dotFlag = true;
                //判定为e，需要没出现过e，并且出过数字了
            } else if ((s.charAt(i) == 'e' || s.charAt(i) == 'E') && !eFlag && numFlag) {
                eFlag = true;
                //避免e以后没有出现数字
                numFlag = false;
                //判定为+-符号，只能出现在第一位或者紧接e后面
            } else if ((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {

                //其他情况，都是非法的
            } else {
                return false;
            }
        }
        //是否出现了数字
        return numFlag;
    }


    /**
     * https://leetcode.cn/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/
     * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
     * @param str
     * @return
     */
    public int strToInt(String str) {
        str = str.trim();
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] strs = str.toCharArray();
        int sign = 1;
        int index = 1;
        if (strs[0] == '-') {
            sign = -1;
        } else if (strs[0] != '+') {
            if (strs[0] >= '0' && strs[0] <= '9') {
                index = 0;
            } else {
                return 0;
            }
        }
        int bndry = Integer.MAX_VALUE / 10;
        // 2147483647 最后一位是7
        int el = Integer.MAX_VALUE % 10;
        int ans = 0;
        for (; index < strs.length; index ++) {
            if (strs[index] < '0' || strs[index] > '9') {
                break;
            }
            if (ans > bndry || (ans == bndry && strs[index] > String.valueOf(el).toCharArray()[0])) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 + (strs[index] - '0');
        }
        return sign * ans;
    }
}
