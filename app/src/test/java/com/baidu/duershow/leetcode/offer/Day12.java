package com.baidu.duershow.leetcode.offer;

public class Day12 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
     * 剑指 Offer 25. 合并两个排序的链表
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode re = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                newHead.next = l1;
                l1 = l1.next;
            } else {
                newHead.next = l2;
                l2 = l2.next;
            }
            newHead = newHead.next;
        }
        if (l1 == null) {
            newHead.next = l2;
        }
        if (l2 == null) {
            newHead.next = l1;
        }
        return re.next;
    }

    /**
     * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
     * 剑指 Offer 52. 两个链表的第一个公共节点
     * 输入两个链表，找出它们的第一个公共节点。
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) { // 方案2:HashSet遍历
        ListNode la = headA;
        ListNode lb = headB;
        while (la != lb) {
            if (la == null) {
                la = headB;
            } else {
                la = la.next;
            }
            if (lb == null) {
                lb = headA;
            } else {
                lb = lb.next;
            }
        }
        return la;
    }

}
