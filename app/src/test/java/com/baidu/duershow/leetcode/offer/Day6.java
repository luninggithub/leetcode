package com.baidu.duershow.leetcode.offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Day6 {

    /**
     * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
     * 面试题32 - I. 从上到下打印二叉树
     * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    /**
     * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
     * 剑指 Offer 32 - II. 从上到下打印二叉树 II
     * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderII(TreeNode root) {
        List<List<Integer>> all = new ArrayList<>();
        if (root == null) {
            return all;
        }
        Deque<TreeNode> dequeue = new LinkedList<>();
        dequeue.add(root);
        while (!dequeue.isEmpty()) {
            int len = dequeue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node = dequeue.poll();
                tmp.add(node.val);
                if (node.left != null) {
                    dequeue.add(node.left);
                }
                if (node.right != null) {
                    dequeue.add(node.right);
                }
            }
            all.add(tmp);

        }
        return all;
    }

    /**
     * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
     * 剑指 Offer 32 - III. 从上到下打印二叉树 III
     * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，
     * 第三行再按照从左到右的顺序打印，其他行以此类推。
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderIII(TreeNode root) {
        List<List<Integer>> all = new ArrayList<>();
        if (root == null) {
            return all;
        }
        Deque<TreeNode> dequeue = new LinkedList<>();
        dequeue.add(root);
        while (!dequeue.isEmpty()) {
            int len = dequeue.size();
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node = dequeue.poll();
                if (all.size() % 2 == 0) {
                    tmp.add(node.val);
                } else {
                    tmp.addFirst(node.val);
                }
                if (node.left != null) {
                    dequeue.add(node.left);
                }
                if (node.right != null) {
                    dequeue.add(node.right);
                }
            }
            all.add(tmp);

        }
        return all;
    }
}
