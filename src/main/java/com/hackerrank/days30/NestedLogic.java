package com.hackerrank.days30;

import java.io.BufferedInputStream;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.stream.IntStream;

public class NestedLogic {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedInputStream(System.in))) {
            LocalDate date1 = readDate(scanner);
            LocalDate date2 = readDate(scanner);
            System.out.println(fine(date1, date2));
        }
    }

    private static int fine(LocalDate date1, LocalDate date2) {
        if (date1.getYear() > date2.getYear()) {
            return 10000;
        } else {
            if (date1.getYear() == date2.getYear()) {
                if (date1.getMonth().getValue() > date2.getMonth().getValue()) {
                    return 500 * (date1.getMonth().getValue() - date2.getMonth().getValue());
                } else {
                    if (date1.getMonth().getValue() == date2.getMonth().getValue()) {
                        if (date1.getDayOfMonth() > date2.getDayOfMonth()) {
                            return 15 * (date1.getDayOfMonth() - date2.getDayOfMonth());
                        }
                    }
                }
            }
        }
        return 0;
    }

    private static LocalDate readDate(Scanner scanner) {
        final int[] date1 = IntStream.range(0, 3).map(i -> scanner.nextInt()).toArray();
        return LocalDate.of(date1[2], date1[1], date1[0]);
    }
}
