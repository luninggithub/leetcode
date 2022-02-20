package com.baidu.duershow.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1226 {

    /**
     * https://leetcode-cn.com/problems/gray-code/
     *
     * 89. 格雷编码
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        return null;
    }

    /**
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
     *
     * 122. 买卖股票的最佳时机 II
     * 贪心算法
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            res += Math.max(0, prices[i] - prices[i-1]);
        }
        return res;
    }

    /**
     * https://leetcode-cn.com/problems/linked-list-cycle-ii/
     *
     * 142. 环形链表 II
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode pos = head;
        Set<ListNode> visitedSet = new HashSet<>();
        while (pos != null) {
            if (visitedSet.contains(pos)) {
                return pos;
            } else {
                visitedSet.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (fast == null || fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

}
