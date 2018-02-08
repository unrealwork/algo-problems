package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

public class TaumAndBday {
    static long taumBday(int b, int w, int x, int y, int z) {
        // Complete this function
        return giftCost(bestBlackCost(x, y, z), bestWhiteCost(x, y, z), b, w);
    }

    static int bestBlackCost(int x, int y, int z) {
        return Math.min(x, z + y);
    }

    static int bestWhiteCost(int x, int y, int z) {
        return Math.min(y, x + z);
    }

    static long giftCost(long bestBlack, long bestWhite, long b, long w) {
        long bC = b * bestBlack;
        long wC = bestWhite * w;
        return bC + wC;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int b = in.nextInt();
            int w = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();
            long result = taumBday(b, w, x, y, z);
            System.out.println(result);
        }
        in.close();
    }
}
