package com.baidu.duershow.leetcode.offer;

import java.util.HashMap;

public class Day20 {

    /**
     * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
     * 剑指 Offer 07. 重建二叉树
     * @param preorder 先根
     * @param inorder 中根
     * @return
     */
    HashMap<Integer, Integer> dicInorder = new HashMap<>();
    int[] preOrder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            dicInorder.put(inorder[i], i);
        }
        return recursive(0, 0, inorder.length - 1);
    }

    private TreeNode recursive(int root, int left, int right) {
        if (left > right) {
            return null;
        }
        int val = preOrder[root];
        TreeNode node = new TreeNode(val);
        int idx = dicInorder.get(val);
        node.left = recursive(root + 1, left, idx - 1);
        node.right = recursive(root + (idx - 1 - left + 1) + 1, idx + 1, right);
        return node;
    }

    /**
     * https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
     * 剑指 Offer 16. 数值的整数次方
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        long b = n;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        double res = 1.0;
        while (b > 0) {
            res = res * x;
            b --;
        }
        return res;
    }

    /**
     * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
     * 剑指 Offer 33. 二叉搜索树的后序遍历序列
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。
     * 假设输入的数组的任意两个数字都互不相同。
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    private boolean recur(int[] postorder, int left, int right) {
        if (left >= right) {
            return true;
        }
        int p = left;
        while (postorder[p] < postorder[right]) {
            p ++;
        }
        int m = p;
        while (postorder[p] > postorder[right]) {
            p ++;
        }
        return p == right && recur(postorder, left, m - 1) && recur(postorder, m, right - 1);
    }
}
