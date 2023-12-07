package com.baidu.duershow.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 知识点梳理：
 * 1. java各数据类型内存占用
 * 2. ThreadLocal用法
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        test(1234);
    }

    private void test(int price) {
        float result = price / 100.0f * 10;
        System.out.println(result);
        String priceStr = String.format("￥%.1f", result);
        System.out.println(priceStr);
    }

}