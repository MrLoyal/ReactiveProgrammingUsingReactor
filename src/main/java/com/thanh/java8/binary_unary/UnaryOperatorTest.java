package com.thanh.java8.binary_unary;

import java.util.function.UnaryOperator;

public class UnaryOperatorTest {

    public static void main(String[] args) {
        UnaryOperator<Integer> uo = i -> (i+2) * i;
        System.out.println(uo.apply(2));
    }
}
