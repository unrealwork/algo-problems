package com.hackerrank.days30;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class TimeComplexity {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedInputStream(System.in))) {
            final int count = scanner.nextInt();
            for (int i = 0; i < count; i++) {
                System.out.println(isPrime(scanner.nextInt())? "Prime" : "Not prime");
            }
        }
    }

    private static boolean isPrime(final int n) {
        if (n == 1) {
            return false;
        }
        if (n < 4) {
            return true;
        }
        final int checkThreshold = (int) Math.ceil(Math.sqrt(n));
        for (int i = 2; i <= checkThreshold; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
