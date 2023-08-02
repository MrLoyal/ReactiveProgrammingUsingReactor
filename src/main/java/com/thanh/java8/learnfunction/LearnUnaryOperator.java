package com.thanh.java8.learnfunction;

import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

public class LearnUnaryOperator {
    public static void main(String[] args) {
        UnaryOperator<String> uo = s -> s + " haha";

        String res = uo.apply("Thanh");
        System.out.println(res);


        IntUnaryOperator iuo = i -> i * i;
        System.out.println(iuo.applyAsInt(20));
    }
}
