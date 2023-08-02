package com.thanh.java8.learnfunction;

import java.util.function.Function;

public class LearnFunction {

    public static void main(String[] args) {
        Function<String, Integer> getLengthFunc = s -> (s == null) ? 0 : s.length();


        System.out.println(getLengthFunc.apply("Thanh"));
        System.out.println(getLengthFunc.apply(" "));
        System.out.println(getLengthFunc.apply(""));
        System.out.println(getLengthFunc.apply(null));

        System.out.println("=============================");
        System.out.println();

        Function<String, Integer> f1 = s -> s.length() + 1;
        Function<Integer, Integer> f2 = i -> i * i;

        int res1 = f1.andThen(f2).apply("Thanh");
        System.out.println("Res1 = " + res1);

        int res2 = f2.compose(f1).apply("Tao");
        System.out.println("Res2 = " + res2);

        System.out.println("Test identity: ");
        System.out.println(Function.identity().apply(f1));

    }



}
