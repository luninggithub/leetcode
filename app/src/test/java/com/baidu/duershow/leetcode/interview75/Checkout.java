package com.baidu.duershow.leetcode.interview75;

import java.util.ArrayDeque;
import java.util.Deque;

public class Checkout {

    private Deque<Integer> dequeueA;
    private Deque<Integer> stackB;

    public Checkout() {
        dequeueA = new ArrayDeque<>();
        stackB = new ArrayDeque<>();
    }

    public int get_max() {
        if (stackB.isEmpty()) {
            return -1;
        }
        return stackB.getLast();
    }

    public void add(int value) {
        dequeueA.offer(value);
        if (stackB.isEmpty() || dequeueA.getLast() >= stackB.getLast()) {
            stackB.offer(value);
        }
    }

    public int remove() {
        if (dequeueA.isEmpty()) {
            return -1;
        }
        int a = dequeueA.removeFirst();
        if (a == stackB.getFirst()) {
            stackB.removeFirst();
        }
        return a;
    }
}
