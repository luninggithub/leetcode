package com.baidu.duershow.leetcode.offer;

public class Day19 {

    /**
     * https://leetcode-cn.com/problems/qiu-12n-lcof/
     * 剑指 Offer 64. 求1+2+…+n
     * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
     * @param n
     * @return
     */
    public int sumNums(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sumNums(n-1);
    }

    /**
     * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else {
                break;
            }
        }
        return root;
    }

    /**
     * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
     * 剑指 Offer 68 - II. 二叉树的最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
