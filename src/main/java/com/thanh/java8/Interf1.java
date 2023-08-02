package com.thanh.java8;

@FunctionalInterface
public interface Interf1 {

    // This public abstract method is required
    void m1();

    default void m2(){ }
    default void m2b(){ }

    static void m3() {

    }

    // void m4();
}
