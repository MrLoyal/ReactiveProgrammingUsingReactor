package com.thanh.java8.binary_unary;

import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;

public class BinaryOperatorTest {
    public static void main(String[] args) {
        BinaryOperator<Integer> bo = Integer::sum;

        System.out.println(bo.apply(1, 2));

        IntBinaryOperator ibo = (i1, i2) -> {
            int a = 23 + i1;
            return a + i2 - 54;
        };

        System.out.println(ibo.applyAsInt(24, 86));
    }
}
