package com.hackerrank.java;

import java.util.Scanner;

public class EOFile {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int counter = 0;
            while (scanner.hasNext()) {
                final String line = scanner.nextLine();
                counter++;
                System.out.printf("%d %s%n", counter, line);
            }
        }
    }
}
