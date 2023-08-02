package com.thanh.java8.learnconsumer;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class LearnConsumer {
    public static void main(String[] args) {
        Consumer<String> c = s -> System.out.println("Accepted: " + s);
        c.accept("Thanh");

        System.out.println();
        Consumer<String> upper = s -> System.out.println("Upper case: " + s.toUpperCase());

        c.andThen(upper).accept("Thanh");


        IntConsumer ic = i -> System.out.println("Consuming: " + i);

        ic.accept(10);
        ic.accept(11);
        ic.accept(12);
    }
}
