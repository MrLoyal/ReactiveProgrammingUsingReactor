package com.thanh.java8.date_n_time;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;

public class LearnPeriod {

    public static void main(String[] args) {
        LocalDate birthday = LocalDate.of(1989, 8, 6);
        LocalDate today = LocalDate.now();

        Period p = Period.between(birthday, today);

        System.out.println("Your are: " + p.getYears() + " years "
                + p.getMonths() + " months "
                + p.getDays() + "days old now.");

        LocalDate deathDay = LocalDate.of(1989 + 60, 8, 6);

        Period p2 = Period.between(today, deathDay);
        System.out.println("You have only " + p2.getYears() + " years "
                + p2.getMonths() + " months and " + p2.getDays()
                + " days left. Do things that are important!");

        System.out.println();
        System.out.println();

        for (int y = 1989; y < 2025; y++) {
            Year year = Year.of(y);
            if (year.isLeap()) {
                System.out.println("Year " + y + " is a leap year");
            } else {
                System.out.println("Year " + y + " is NOT a leap year");
            }
        }
    }

}
