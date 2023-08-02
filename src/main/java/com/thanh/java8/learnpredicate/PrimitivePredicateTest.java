package com.thanh.java8.learnpredicate;

import java.util.function.IntPredicate;

public class PrimitivePredicateTest {
    public static void main(String[] args) {
        IntPredicate ip = i -> i % 2 == 0;

        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        for (int i : arr) {
            if (ip.test(i)) {
                System.out.println(i);
            }
        }
    }
}
