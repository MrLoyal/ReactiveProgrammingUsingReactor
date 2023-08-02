package com.thanh.java8.learnpredicate;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class NullOrEmptyStringTest {

    public static void main(String[] args) {

        Predicate<String> nullStr = Objects::isNull;

        Predicate<String> emptyStr = s -> (s != null && s.trim().length() == 0);

        Predicate<String> nullOrEmpty = nullStr.or(emptyStr);

        List<String> list = List.of("A", " ", "", "     ");

        for (String s : list) {
            if (nullOrEmpty.test(s)) {
                System.out.println(".:" + s + ":.");
            }
        }

    }
}
