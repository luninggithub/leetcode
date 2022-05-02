package com.baidu.duershow.leetcode.offer;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Day17 {

    /**
     * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
     * 剑指 Offer 40. 最小的k个数
     * 输入整数数组 arr ，找出其中最小的 k 个数。
     * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }


    /**
     * https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
     * 剑指 Offer 41. 数据流中的中位数
     *
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */
    class MedianFinder {
        PriorityQueue<Integer> A;
        PriorityQueue<Integer> B;
        public MedianFinder() {
            A = new PriorityQueue<>(); // 小顶堆，保存较大的一半
            B = new PriorityQueue<>((o1, o2) -> o2 - o1); // 大顶堆，保存较小的一半
        }
        public void addNum(int num) {
            B.add(num);
            A.add(B.poll());
            if (B.size() + 1 < A.size()) {
                B.add(A.poll());
            }
        }
        public double findMedian() {
            if (A.size() > B.size()) {
                return A.peek();
            } else {
                return (double) (A.peek() + B.peek()) / 2;
            }
        }
    }
}
