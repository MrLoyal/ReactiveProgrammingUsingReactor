package com.thanh.java8.learnpredicate;

import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        Predicate<Integer> greaterThan10 = i -> i > 10;
        Predicate<Integer> evenNumber = i -> i % 2 == 0;


        int[] numbers = new int[]{1, 3, 4, 5, 10, 20, 25, 30};

        System.out.println("Greater than 10:");
        for (int i : numbers) {
            if (greaterThan10.test(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();


        System.out.println("Even numbers:");
        for (int i : numbers) {
            if (evenNumber.test(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        System.out.println("Greater than 10 and Even numbers:");
        for (int i : numbers) {
            if (greaterThan10.and(evenNumber).test(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        System.out.println("(NOT Greater than 10) and Even numbers:");
        for (int i : numbers) {
            if (greaterThan10.negate().and(evenNumber).test(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        Predicate<String> equalToThanh = Predicate.isEqual("Thanh");
        System.out.println("Is equal to Thanh: " + equalToThanh.test("Thanh"));

    }
}
