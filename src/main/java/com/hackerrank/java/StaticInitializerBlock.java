package com.hackerrank.java;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class StaticInitializerBlock {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedInputStream(System.in))) {
            final int breadth = scanner.nextInt();
            final int height = scanner.nextInt();
            if (breadth > 0 && height > 0) {
                System.out.println(breadth*height);
            } else {
                System.out.println("java.lang.Exception: Breadth and height must be positive");
            }
        }
    }
}
