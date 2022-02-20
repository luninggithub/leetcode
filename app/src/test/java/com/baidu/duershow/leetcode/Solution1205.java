package com.baidu.duershow.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution1205 {

    /**
     * https://leetcode-cn.com/problems/spiral-matrix/
     *
     * 54. 螺旋矩阵
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        // 二维数组为空 或者 行数为0 或者 列数为0
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int left = 0;
        int right = columns - 1;
        int top = 0;
        int bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int colum = left; colum <= right; colum ++) {
                order.add(matrix[top][colum]);
            }
            for (int row = top + 1; row <= bottom; row ++) {
                order.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int colum = right - 1; colum > left; colum --) {
                    order.add(matrix[bottom][colum]);
                }
                for (int row = bottom; row > top; row --) {
                    order.add(matrix[row][left]);
                }
            }
            top ++;
            right --;
            left ++;
            bottom --;
        }
        return order;
    }

}
