package com.hackerrank.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Loops1 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());
            printMultiplyTable(n);
        }
    }

    private static void printMultiplyTable(int n) {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d x %d = %d%n", n, i + 1, n * (i + 1));
        }
    }
}
