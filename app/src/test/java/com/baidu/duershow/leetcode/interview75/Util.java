package com.baidu.duershow.leetcode.interview75;

import com.baidu.duershow.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public ListNode get(ListNode head, int cnt) {
        ListNode newHead = head;
        int len = 0;
        while (newHead != null) {
            len ++;
            newHead = newHead.next;
        }
        int index = len - cnt;
        newHead = head;
        while (newHead != null && index > 0) {
            newHead = newHead.next;
            index --;
        }
        return newHead;
    }

    public ListNode combine(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode head = node;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        return node.next;
    }

    public ListNode getInNode(ListNode listA, ListNode listB) {
        ListNode headA = listA;
        ListNode headB = listB;
        int countA = 0;
        while (headA != null) {
            countA ++;
            headA = headA.next;
        }
        int countB = 0;
        while (headB != null) {
            countB ++;
            headB = headB.next;
        }
        headA = listA;
        headB = listB;
        if (countA > countB) {
            int c = countA - countB;
            while (headA != null) {
                if (c <= 0) {
                    if (headA.val == headB.val) {
                        return headA;
                    }
                    headB = headB.next;
                }
                headA = headA.next;
                c --;
            }
        } else {
            int c = countB - countA;
            while (headB != null) {
                if (c <= 0) {
                    if (headB.val == headA.val) {
                        return headB;
                    }
                    headA = headA.next;
                }
                headB = headB.next;
                c --;
            }
        }
        return null;
    }

    public int[] getArray(int[] origin) {
        List<Integer> ou = new ArrayList<>();
        List<Integer> ji = new ArrayList<>();
        for (int i = 0; i < origin.length; i++) {
            if (origin[i] % 2 == 0) {
                ou.add(origin[i]);
            } else {
                ji.add(origin[i]);
            }
        }
        ji.addAll(ou);
        for (int i = 0; i < origin.length; i ++) {
            origin[i] = ji.get(i);
        }
        return origin;
    }
}
