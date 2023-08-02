package com.thanh.java8.learnsupplier;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class LearnSupplier {

    public static void main(String[] args) {
        Supplier<LocalDateTime> timeSupplier = LocalDateTime::now;

        System.out.println(timeSupplier.get());
        sleep(200);
        System.out.println(timeSupplier.get());
        System.out.println(timeSupplier.get());
        sleep(300);
        System.out.println(timeSupplier.get());


    }

    private static void sleep(long ms) {
        try {
            TimeUnit.MILLISECONDS.sleep(ms);
        } catch (InterruptedException e) {
            //
        }
    }
}
