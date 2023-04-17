package com.baidu.duershow.leetcode.offer2;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;

public class Day2 {

    @Test
    public void addition_isCorrect() {
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 剑指 Offer 06. 从尾到头打印链表
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     */
    class Solution {
        // 关键之处：链表反转，由于是单向链表只能向后遍历，因此倒序 可以考虑使用栈（先进后出）
        // 方法2：链表虽然不能倒着遍历，但要求返回数组，可以从最后一个元素开始存
        public int[] reversePrint(ListNode head) {
            LinkedList<Integer> stack = new LinkedList<>();
            while (head != null) {
                stack.push(head.val);
                head = head.next;
            }
            int[] res = new int[stack.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = stack.pop();
            }
            return res;
        }

        /**
         * 剑指 Offer 24. 反转链表
         * @param head
         * @return
         */
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            // 关键之处，画图关注
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }

        /**
         * 剑指 Offer 35. 复杂链表的复制
         * @param head
         * @return
         */
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            Node cur = head;
            // 用hashmap存储原链表和复制链表的对应关系
            HashMap<Node, Node> nodeMap = new HashMap<>();
            while (cur != null) {
                Node temp = new Node(cur.val);
                nodeMap.put(cur, temp);
                cur = cur.next;
            }
            cur = head;
            while (cur != null) {
                nodeMap.get(cur).next = nodeMap.get(cur.next);
                nodeMap.get(cur).random = nodeMap.get(cur.random);
                cur = cur.next;
            }
            return nodeMap.get(head);
        }

        public Node copyRandomList2(Node head) {
            if (head == null) {
                return null;
            }
            // 复制新节点，拼接到原链表中
            Node cur = head;
            while (cur != null) {
                Node temp = new Node(cur.val);
                Node curNext = cur.next;
                cur.next = temp;
                temp.next = curNext;
                cur = cur.next.next;
            }

            // 处理新建节点的random指向
            cur = head;
            while (cur != null) {
                if (cur.random != null) {
                    cur.next.random = cur.random.next;
                }
                cur = cur.next.next;
            }

            // 拆分链表
            Node original = head; // 原始链表
            Node a = head.next; // 新链表的头部
            Node res = head.next; // 再存一份新链表头，用于最后返回新链表。遍历后再取就取不到头了
            while (a.next != null) { // 新链表最后一个元素为null
                original.next = original.next.next;
                a.next = a.next.next;
                a = a.next;
                original = original.next;
            }
            original.next = null;
            return res;
        }
    }

}
