package com.hackerrank.algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class QueensAttack2 {
    static long queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        // Complete this function
        return new PathChecker(r_q - 1, c_q - 1, n, obstacles).getBeaten();
    }

    static class PathChecker {
        private final int[][] obstacles;
        private long beaten = 0;

        PathChecker(int startI, int startJ, int n, int[][] obstacles) {
            this.obstacles = obstacles;
            beaten += coveredByPath(p -> p[0] == startI && p[1] > startJ, p -> p[1] - startJ - 1, () -> n - 1 - startJ);
            beaten += coveredByPath(p -> p[0] == startI && p[1] < startJ, p -> startJ - p[1] - 1, () -> startJ);
            beaten += coveredByPath(p -> p[1] == startJ && p[0] > startI, p -> p[0] - startI - 1, () -> n - 1 - startI);
            beaten += coveredByPath(p -> p[1] == startJ && p[0] < startI, p -> startI - p[0] - 1, () -> startI);
            beaten += coveredByPath(p -> (p[1] - p[0]) == (startJ - startI) && p[0] < startI, p -> startI - p[0] - 1, () -> Math.min(startI, startJ));
            beaten += coveredByPath(p -> (p[1] - p[0]) == (startJ - startI) && p[0] > startI, p -> p[0] - startI - 1, () -> Math.min(n - startI - 1, n - startJ - 1));
            beaten += coveredByPath(p -> (p[1] + p[0]) == (startJ + startI) && p[0] < startI, p -> startI - p[0] - 1, () -> Math.min(startI, startJ));
            beaten += coveredByPath(p -> (p[1] + p[0]) == (startJ + startI) && p[0] > startI, p -> p[0] - startI - 1, () -> Math.min(n - startI - 1, n - startJ - 1));
        }

        private int coveredByPath(Predicate<int[]> pathPredicate, Function<int[], Integer> distanceFunction, Supplier<Integer> freePathSupplier) {
            return Arrays.stream(obstacles)
                    .filter(pathPredicate)
                    .map(distanceFunction)
                    .min(Integer::compareTo)
                    .orElse(freePathSupplier.get());
        }

        public long getBeaten() {
            return beaten;
        }
    }


    static class HorizontalUpPath implements Path {

        @Override
        public int distTo(int[] p) {
            return 0;
        }

        @Override
        public int length() {
            return 0;
        }

        @Override
        public boolean isOnPath(int[] p) {
            return false;
        }
    }


    interface Path {
        int distTo(int[] p);

        int length();

        boolean isOnPath(int[] p);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int r_q = in.nextInt();
        int c_q = in.nextInt();
        int[][] obstacles = new int[k][2];
        for (int obstacles_i = 0; obstacles_i < k; obstacles_i++) {
            for (int obstacles_j = 0; obstacles_j < 2; obstacles_j++) {
                obstacles[obstacles_i][obstacles_j] = in.nextInt();
            }
        }
        long result = queensAttack(n, k, r_q, c_q, obstacles);
        System.out.println(result);
        in.close();
    }
}
