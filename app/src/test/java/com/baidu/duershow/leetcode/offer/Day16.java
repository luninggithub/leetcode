package com.baidu.duershow.leetcode.offer;

import java.util.Arrays;
import java.util.Comparator;

public class Day16 {

    /**
     * https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
     * 剑指 Offer 45. 把数组排成最小的数
     * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        StringBuilder res = new StringBuilder();
        for (String val : strs) {
            res.append(val);
        }
        return res.toString();
    }

    /**
     * https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
     * 剑指 Offer 61. 扑克牌中的顺子
     * 从【若干副】扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
     * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        int joker = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                joker ++;
            } else if (nums[i] == nums[i+1]) {
                return false;
            }
        }
        return nums[nums.length - 1] - nums[joker] <= 4;
    }
}
