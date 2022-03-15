package com.baidu.duershow.leetcode.offer;

import java.util.LinkedList;
import java.util.List;

public class Day15 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
     * 剑指 Offer 34. 二叉树中和为某一值的路径
     * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
     * 叶子节点 是指没有子节点的节点。
     * @param root
     * @param target
     * @return
     */
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) { // 深度优先遍历
        backtrace(root, target);
        return res;
    }
    private void backtrace(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        target = target - root.val;
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList<>(path));
        }
        backtrace(root.left, target);
        backtrace(root.right, target);
        path.removeLast();
    }


    /**
     * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
     * 剑指 Offer 36. 二叉搜索树与双向链表
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
     * @param root
     * @return
     */
    TreeNode head;
    TreeNode pre;
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    void dfs(TreeNode cur) {
        if (cur == null) return;
        dfs(cur.left);
        if (pre == null) {
            head = cur;
        } else {
            pre.right = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }

    // 打印中序遍历
    void dfs_m(TreeNode root) {
        if(root == null) return;
        dfs(root.left); // 左
        System.out.println(root.val); // 根
        dfs(root.right); // 右
    }


    /**
     * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
     * 剑指 Offer 54. 二叉搜索树的第k大节点
     * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
     * @param root
     * @param k
     * @return
     */
    List<Integer> list = new LinkedList<>();
    public int kthLargest(TreeNode root, int k) {
        dfs_(root);
        return list.get(list.size() - k);
    }
    private void dfs_(TreeNode root) { // 中序遍历
        if (root == null) {
            return;
        }
        dfs_(root.left);
        list.add(root.val);
        dfs_(root.right);
    }
}
