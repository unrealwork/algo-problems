package com.stepik.algods;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Backpack {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int bSize = scanner.nextInt();
            int wSize = scanner.nextInt();
            int[] weights = IntStream.range(0, wSize)
                    .map(i -> scanner.nextInt())
                    .toArray();

            System.out.println(solve(bSize, weights));
        }
    }

    private static long solve(final int bSize, int[] weights) {
        int[][] memo = new int[bSize + 1][weights.length + 1];
        for (int i = 0; i <= bSize; i++) {
            memo[i][0] = 0;
        }
        for (int i = 0; i <= weights.length; i++) {
            memo[0][i] = 0;
        }

        for (int i = 1; i <= weights.length; i++) {
            for (int w = 1; w <= bSize; w++) {
                memo[w][i] = memo[w][i - 1];
                int c = weights[i - 1];
                if (c <= w) {
                    memo[w][i] = Math.max(memo[w][i], memo[w - c][i - 1] + c);
                }
            }
        }
        return memo[bSize][weights.length];
    }
}
