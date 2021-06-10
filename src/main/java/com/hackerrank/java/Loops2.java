package com.hackerrank.java;

import java.util.Scanner;

class Loops2 {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int e = a;
            int pow2 = 1;
            for (int j = 0; j < n; j++) {
                if (j != 0) {
                    pow2 *= 2;
                }
                e = e + pow2*b;
                System.out.printf("%d ", e);
            }
            System.out.println();
        }
        in.close();
    }
}
