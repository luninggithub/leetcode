package com.baidu.duershow.leetcode.interview75;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Solution {

    private int[] spiralArray(int[][] array) {
        if (array.length == 0) return new int[0];
        int left = 0;
        int right = array.length - 1;
        int top = 0;
        int bottom = array[0].length - 1;
        int[] res = new int[(right + 1) * (bottom + 1)];
        int x = 0;
        while (true) {
            for (int index = left; index <= right; index++) {
                res[x++] = array[top][index];
            }
            top ++;
            if (top > bottom) {
                break;
            }
            for (int index = top; index <= bottom; index ++) {
                res[x++] = array[index][right];
            }
            right --;
            if (right < left) {
                break;
            }
            for (int index = right; index >= left; index --) {
                res[x++] = array[bottom][index];
            }
            bottom --;
            if (bottom < top) {
                break;
            }
            for (int index = bottom; index >= top; index --) {
                res[x++] = array[index][left];
            }
            left ++;
            if (left > right) {
                break;
            }
        }
        return res;
    }

    public boolean isValid(int[] putIn, int[] takeOut) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i : putIn) {
            stack.push(i);
            while (!stack.isEmpty() && stack.peek() == takeOut[index]) {
                stack.pop();
                index ++;
            }
        }
        return stack.isEmpty();
    }

    private int documents(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i : array) {
            if (list.contains(i)) {
                return i;
            }
            list.add(i);
        }
        return -1;
    }

    private int documents2(int[] array) {
        int index = 0;
        while (index <= array.length) {
            if (index == array[index]) {
                index ++;
                continue;
            }
            if (array[index] == array[array[index]]) {
                return array[index];
            }
            int temp = array[index];
            array[index] = array[array[index]];
            array[array[index]] = temp;
        }
        return -1;
    }


    private int countTarget(int[] array, int target) {
        return abc(array, target) - abc(array, target - 1);
    }

    private int abc(int[] array, int target) {
        int i = 0;
        int j = array.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (array[m] <= target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }

    public int takeAttention(int[] records) {
        int start = 0;
        int end = records.length;
        while (start < end) {
            int m = (start + end) / 2;
            if (records[m] == m) {
                start = m + 1;
            } else {
                end = m - 1;
            }
        }
        return start;
    }

    /**
     * @param source
     * @param target
     */
    public boolean findTargetPlan(int[][] source, int target) {
        int row = 0;
        int column = source[0].length - 1;
        while (row <= source.length - 1 && column >= 0) {
            if (source[row][column] > target) {
                column = column - 1;
            } else if (source[row][column] < target) {
                row = row + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public int stockManagement(int[] stocks) {
        for (int i = 0; i < stocks.length-1; i++) {
            if (stocks[i] > stocks[i + 1]) {
                return stocks[i + 1];
            }
        }
        return -1;
    }

    public int stockManagement2(int[] stocks) {
        int i = 0;
        int j = stocks.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (stocks[m] > stocks[j]) {
                i = m + 1;
            } else if (stocks[m] < stocks[j]) {
                j = m;
            } else {
                j--;
            }
        }
        return stocks[i];
    }

    private char abc(String str) {
        char[] chars = str.toCharArray();
        Map<Character, Boolean> map = new HashMap<>();
        for (char c : chars) {
            if (!map.containsKey(c)) {
                map.put(c, true);
            } else {
                map.put(c, false);
            }
        }
        for (char c : chars) {
            if (Boolean.FALSE.equals(map.get(c))) {
                return c;
            }
        }
        return ' ';
    }
}
