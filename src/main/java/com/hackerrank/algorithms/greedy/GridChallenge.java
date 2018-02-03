package com.hackerrank.algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class GridChallenge {

    static String gridChallenge(String[] grid) {
        // Complete this function
        if (!isVerticalCorrect(rotateLeft(sortedRows(grid)))) {
            return "NO";
        }
        return "YES";
    }

    private static String[] rotateLeft(String[] grid) {
        StringBuffer[] verticalPresentation = IntStream.range(0, grid[0].length())
                .mapToObj(i -> new StringBuffer()).toArray(StringBuffer[]::new);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                verticalPresentation[j].append(grid[i].charAt(j));
            }
        }
        return Arrays.stream(verticalPresentation).map(StringBuffer::toString).toArray(String[]::new);
    }

    private static String[] sortedRows(String[] grid) {
        return IntStream.range(0, grid.length).mapToObj(i -> {
            int[] sorted = grid[i].chars().sorted().toArray();
            return new String(sorted, 0, sorted.length);
        }).toArray(String[]::new);
    }

    private static boolean isVerticalCorrect(String[] grid) {
        return Arrays.stream(grid).allMatch(GridChallenge::isSorted);
    }

    private static boolean isSorted(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isHorizontalCorrect(String[] grid) {
        int last = -1;
        for (int i = 0; i < grid.length; i++) {
            int min = grid[i].chars().min().getAsInt();
            int max = grid[i].chars().max().getAsInt();
            if (last > min) {
                return false;
            }
            last = max;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            String[] grid = new String[n];
            for (int grid_i = 0; grid_i < n; grid_i++) {
                grid[grid_i] = in.next();
            }
            String result = gridChallenge(grid);
            System.out.println(result);
        }
        in.close();
    }
}