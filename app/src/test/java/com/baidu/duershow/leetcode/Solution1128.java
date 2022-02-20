package com.baidu.duershow.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution1128 {

    @Test
    public void main() {
        int[] input = new int[]{1, 2, 3};
        permute(input);
    }

    /**
     * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
     *
     * 33. 搜索旋转排序数组
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) { // 前半部分是有序
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * https://leetcode-cn.com/problems/multiply-strings/
     *
     * 43. 字符串相乘
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int[] ans = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i --) {
            int val1 = num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j --) {
                int val2 = num2.charAt(j) - '0';
                ans[i + j + 1] += val1 * val2;
            }
        }
        for (int i = ans.length - 1; i >= 1; i--) {
            ans[i-1] = ans[i-1] + ans[i] / 10;
            ans[i] = ans[i] % 10;
        }
        int index = ans[0] == 0 ? 1 : 0;
        StringBuilder ansStr = new StringBuilder();
        while (index < ans.length) {
            ansStr.append(ans[index]);
            index ++;
        }
        return ansStr.toString();
    }

    /**
     * https://leetcode-cn.com/problems/permutations/
     *
     * 46. 全排列
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<Integer>();
        boolean[] used = new boolean[len];
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        System.out.println(path.toString());
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, path, used, res);
            path.removeLast();
            used[i] = false;
        }
    }

}
