package com.baidu.duershow.leetcode.offer;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Day28 {

    @Test
    public void addition_isCorrect() {
        permutation("abc");
    }


    /**
     * https://leetcode.cn/problems/xu-lie-hua-er-cha-shu-lcof/
     * 剑指 Offer 37. 序列化二叉树
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "[]";
            }
            StringBuilder res = new StringBuilder();
            res.append("[");
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node != null) {
                    res.append(node.val).append(",");
                    queue.add(node.left);
                    queue.add(node.right);
                } else {
                    res.append("null").append(",");
                }
            }
            // delele last ","
            res.deleteCharAt(res.length() - 1);
            res.append("]");
            return res.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.equals("[]")) {
                return null;
            }
            // delete "[" and "]"
            String[] vals = data.substring(1, data.length() - 1).split(",");
            TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int i = 1;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (!vals[i].equals("null")) {
                    node.left = new TreeNode(Integer.parseInt(vals[i]));
                    queue.add(node.left);
                }
                i++;
                if (!vals[i].equals("null")) {
                    node.right = new TreeNode(Integer.parseInt(vals[i]));
                    queue.add(node.right);
                }
                i++;
            }
            return root;
        }
    }


    /**
     * https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof/
     * 剑指 Offer 38. 字符串的排列
     * 输入一个字符串，打印出该字符串中字符的所有排列
     * @param s
     * @return
     */
    List<String> res = new LinkedList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }
    void dfs(int x) {
        if(x == c.length - 1) {
            res.add(String.valueOf(c)); // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x; i < c.length; i++) {
            if(set.contains(c[i])) continue; // 重复，因此剪枝
            set.add(c[i]);
            swap(i, x); // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1); // 开启固定第 x + 1 位字符
            swap(i, x); // 恢复交换
        }
    }
    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
}
