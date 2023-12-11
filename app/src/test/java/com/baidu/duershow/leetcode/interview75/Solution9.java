package com.baidu.duershow.leetcode.interview75;

import com.baidu.duershow.leetcode.ListNode;

public class Solution9 {

    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode newHead = head;
        while (newHead.next != null && newHead.next.val != val) {
            newHead = newHead.next;
        }
        if (newHead.next != null) {
            newHead.next = newHead.next.next;
        }
        return head;
    }

}
