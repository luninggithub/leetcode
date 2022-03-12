package com.baidu.duershow.leetcode.offer;

import java.util.LinkedList;
import java.util.List;

public class Day13 {
    /**
     * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
     * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int temp;
        while (i < j) {
            while (i < j && nums[i] % 2 == 1) {
                i++;
            }
            while (i < j && nums[j] % 2 == 0) {
                j--;
            }
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }

    /**
     * https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
     * 剑指 Offer 57. 和为s的两个数字
     * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                left ++;
            } else if (sum > target) {
                right --;
            } else {
                return new int[]{nums[left], nums[right]};
            }
        }
        return null;
    }
    public int[] twoSum2(int[] nums, int target) {
        List<Integer> list = new LinkedList<>();
        for (int val : nums) {
            if (list.contains(target-val)) {
                return new int[] {val, target-val};
            } else {
                list.add(val);
            }
        }
        return null;
    }

    /**
     * https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
     * 剑指 Offer 58 - I. 翻转单词顺序
     * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
     * 例如输入字符串"I am a student. "，则输出"student. a am I"。
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        s = s.trim();
        String[] strs = s.split("\\s+");
        StringBuilder builder = new StringBuilder();
        for (int i = strs.length - 1; i >=0; i--) {
            builder.append(strs[i]);
            if (i != 0) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }
}
