package com.baidu.duershow.leetcode.offer;

import java.util.Arrays;

public class Day23 {

    /**
     * https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
     * 剑指 Offer 39. 数组中出现次数超过一半的数字
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int lastValue = 0;
        for (int i : nums) {
            if (i == lastValue) {
                count ++;
                if (count + 1 > nums.length / 2) {
                    return i;
                }
            } else {
                count = 0;
            }
            lastValue = i;
        }
        return lastValue;
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement3(int[] nums) {
        int vote = 0;
        int x = 0;
        for (int i : nums) {
            if (vote == 0) {
                x = i;
                vote ++;
            } else {
                if (i == x) {
                    vote ++;
                } else {
                    vote --;
                }
            }
        }
        return x;
    }

    /**
     * https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/
     * 剑指 Offer 66. 构建乘积数组
     * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
     * 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
     * @param a
     * @return
     */
    public int[] constructArr(int[] a) {
        if (a.length == 0) {
            return new int[0];
        }
        int[] b = new int[a.length];
        b[0] = 1;
        for (int i = 1; i < a.length; i ++) {
            b[i] = b[i-1] * a[i-1];
        }
        int temp = 1;
        for (int i = a.length - 2; i >= 0; i--) {
            temp = temp * a[i + 1];
            b[i] = b[i] * temp;
        }
        return b;
    }
}
