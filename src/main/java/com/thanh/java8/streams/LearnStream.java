package com.thanh.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LearnStream {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Alpha", "Bravo", "Charli", "Delta", "Foxtrot", "Echo");

        long count = list.stream().filter(s -> s.length() > 5)
                .count();
        System.out.println("Filtered count = " + count);

        List<String> sortedList = list.stream().sorted().toList();
        System.out.println(sortedList);

        Optional<String> minString = list.stream().min(String::compareTo);
        System.out.println("Min string: " + minString);

        list.stream().forEach(s -> System.out.println("Consuming s = " + s));

    }
}
