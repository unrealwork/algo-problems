package com.hackerrank.algorithms.implementation;

import java.time.LocalDate;
import java.util.Scanner;

public class LibraryFine {

    public static final int FIXED_FINE = 10000;
    public static final int MONTHLY_FEE = 500;
    public static final int DAILY_FEE = 15;

    static long libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        // Complete this function
        LocalDate limitDate = LocalDate.of(y2, m2, d2);
        LocalDate returnDate = LocalDate.of(y1, m1, d1);
        if (returnDate.compareTo(limitDate) <= 0) {
            return 0;
        }
        if (y1 != y2) {
            return FIXED_FINE;
        }
        if (m1 != m2) {
            return (m1 - m2) * MONTHLY_FEE;
        }
        long days = d1 - d2;
        return days * DAILY_FEE;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int d1 = in.nextInt();
        int m1 = in.nextInt();
        int y1 = in.nextInt();
        int d2 = in.nextInt();
        int m2 = in.nextInt();
        int y2 = in.nextInt();
        long result = libraryFine(d1, m1, y1, d2, m2, y2);
        System.out.println(result);
        in.close();
    }
}
