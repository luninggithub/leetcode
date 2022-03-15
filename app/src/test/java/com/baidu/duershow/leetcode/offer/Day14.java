package com.baidu.duershow.leetcode.offer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Day14 {

    /**
     * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
     * 同一个单元格内的字母不允许被重复使用
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) { // 难度较大：dfs
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][]board, char[] words, int i, int j, int k) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j]!= words[k]) {
            return false;
        }
        if (k == words.length - 1) {
            return true;
        }
        board[i][j] = '\0';
        boolean res = dfs(board, words, i+1, j, k+1)
                || dfs(board, words, i-1, j, k+1)
                || dfs(board, words, i, j+1, k+1)
                ||dfs(board, words, i, j-1, k+1);
        board[i][j] = words[k];
        return res;
    }


    /**
     * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
     * 剑指 Offer 13. 机器人的运动范围
     * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
     * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
     * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
     * 请问该机器人能够到达多少个格子？
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) { // 深度优先遍历：DFS
        boolean[][] visited = new boolean[m][n];
        return dfs(visited, m, n, k, 0, 0);
    }

    private int dfs(boolean[][] visited, int m, int n, int k, int i, int j) {
        if(i >= m || j >= n || visited[i][j] || bitSum(i) + bitSum(j) > k) return 0;
        visited[i][j] = true;
        return 1 + dfs(visited, m, n, k, i + 1, j) + dfs(visited, m, n, k, i, j + 1) ;
    }

    private int bitSum(int n) {
        int sum = 0;
        while(n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }


    private int m;
    private int n;
    private int k;
    private boolean[][] visited;
    public int movingCount1(int m, int n, int k) { // 深度优先遍历：DFS
        this.m = m;
        this.n = n;
        this.k = k;
        visited = new boolean[m][n];
        return dfs(0,0,0,0);
    }

    private int dfs(int i, int j, int si, int sj) {
        if (i >= m || j >= n || visited[i][j] || si + sj > k) {
            return 0;
        }
        visited[i][j] = true;
        return 1
                + dfs(i+1, j, (i + 1) % 10 != 0 ? si + 1 : si-8, sj)
                + dfs(i, j+1, si, (j + 1) % 10 != 0 ? sj + 1 : sj-8);
    }



    public int movingCount2(int m, int n, int k) { // 广度优先遍历：BFS
        boolean[][] visited = new boolean[m][n];
        int[] root = new int[] {0, 0, 0, 0};
        Queue<int[]> deque = new ArrayDeque();
        deque.add(root);
        int res = 0;
        while (!deque.isEmpty()) {
            int[] r = deque.poll();
            int i = r[0];
            int j = r[1];
            int si = r[2];
            int sj = r[3];
            if (i >= m || j >= n || si + sj > k || visited[i][j]) {
                continue;
            }
            visited[i][j] = true;
            deque.add(new int[]{i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj});
            deque.add(new int[]{i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8});
            res += 1;
        }
        return res;
    }
}
