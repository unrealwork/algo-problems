package com.hackerrank.java;

import java.util.Scanner;

public class IfElse {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        scanner.close();
        System.out.println(weird(N));
    }

    private static String weird(int n) {
        if ((n % 2 == 0) && (n >= 2 && n <= 5 || (n > 20))) {
            return "Not Weird";
        }
        return "Weird";
    }
}
