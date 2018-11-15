package com.stepik.algods;


import java.util.Scanner;
import java.util.stream.IntStream;

public class Stairs {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            final int n = sc.nextInt();
            int[] w = IntStream.range(0, n).map(i -> sc.nextInt()).toArray();
            System.out.println(solve(w));
        }
    }

    static long solve(int[] w) {
        int[] memo = new int[w.length];
        memo[0] = w[0];
        if (w.length > 1) {
            memo[1] = Math.max(w[0] + w[1], w[1]);
        }
        for (int i = 2; i < w.length; i++) {
            memo[i] = Math.max(memo[i - 2] + w[i], memo[i - 1] + w[i]);
        }
        return memo[w.length - 1];
    }
}
