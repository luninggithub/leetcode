package com.baidu.duershow.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1127 {
    @Test
    public void main() {
        int[] array = new int[]{-1,2,1,-4};
        int a = threeSumClosest(array, 1);
        System.out.println(a);
    }


    /**
     * https://leetcode-cn.com/problems/container-with-most-water/
     *
     * 11. 盛最多水的容器
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        while (left < right) {
            int temp = (right - left) * Math.min(height[left], height[right]);
            ans = Math.max(ans, temp);
            if (height[left] < height[right]) {
                left ++;
            } else {
                right --;
            }
        }
        return ans;
    }

    /**
     * https://leetcode-cn.com/problems/3sum/
     *
     * 15. 三数之和
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
     * 请你找出所有和为 0 且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 3) {
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ArrayList<Integer> item = new ArrayList<>();
                    item.add(nums[i]);
                    item.add(nums[left]);
                    item.add(nums[right]);
                    ans.add(item);
                    while (left < right && nums[left] == nums[left + 1]) {
                        left ++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right --;
                    }
                    left ++;
                    right --;
                } else if (sum > 0) {
                    right --;
                } else {
                    left ++;
                }
            }
        }
        return ans;
    }

    /**
     * https://leetcode-cn.com/problems/3sum-closest/
     *
     * 16. 最接近的三数之和
     * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
     * 返回这三个数的和。
     * 假定每组输入只存在恰好一个解。
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        if (len == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        Arrays.sort(nums);
        if (nums[0] + nums[1] + nums[2] > target) {
            return nums[0] + nums[1] + nums[2];
        }
        int minDis = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int dis = sum - target;
                if (dis == 0) {
                    return sum;
                } else if (dis > 0) {
                    right --;
                } else {
                    left ++;
                }
                if (Math.abs(minDis) > Math.abs(dis)) {
                    minDis = dis;
                }
            }
        }
        return target + minDis;
    }
}
