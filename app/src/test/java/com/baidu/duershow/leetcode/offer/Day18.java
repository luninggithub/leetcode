package com.baidu.duershow.leetcode.offer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Day18 {

    /**
     * https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
     * 剑指 Offer 55 - I. 二叉树的深度
     * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，
     * 最长路径的长度为树的深度。
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size --;
            }
            ans ++;
        }
        return ans;
    }

    /**
     * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
     * 剑指 Offer 55 - II. 平衡二叉树
     * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，
     * 那么它就是一棵平衡二叉树。
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return maxDep(root) != -1;
    }

    private int maxDep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDep(root.left);
        if (left == -1) {
            return -1;
        }
        int right = maxDep(root.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) <= 1) {
            return Math.max(left, right) + 1;
        }
        return -1;
    }

}
