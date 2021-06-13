package com.hackerrank.java.bignumer;

import java.io.BufferedInputStream;
import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerUsage {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        try (Scanner scanner = new Scanner(new BufferedInputStream(System.in))) {
            BigInteger a = scanner.nextBigInteger();
            BigInteger b = scanner.nextBigInteger();
            System.out.println(a.add(b));
            System.out.println(a.multiply(b));
        }
    }
}
