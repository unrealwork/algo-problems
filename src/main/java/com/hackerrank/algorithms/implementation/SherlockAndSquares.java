package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

public class SherlockAndSquares {

    static int squares(int a, int b) {
        // Complete this function
        int start = (int) Math.floor(Math.sqrt(a));
        int end = (int) Math.ceil(Math.sqrt(b));
        int count = 0;
        for (int i = start; i <= end; i++) {
            int square = i * i;
            if (square >= a && square <= b) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int result = squares(a, b);
            System.out.println(result);
        }
        in.close();
    }
}
