package com.hackerrank.algorithms.greedy;

import java.util.Scanner;

public class GridChallange {

  static String gridChallenge(String[] grid) {
    // Complete this function
    boolean isPossible = true;
    int last = -1;
    /*int[][] segments = Arrays.stream(grid).map(
        s -> new int[]{s.chars().min().getAsInt(), s.chars().max().getAsInt()})
        .sorted(Comparator.comparingInt(a -> a[0])).toArray(int[][]::new);*/
    for (int i = 0; i < grid.length; i++) {
      int min = grid[i].chars().min().getAsInt();
      int max = grid[i].chars().max().getAsInt();
      if (min < last) {
        break;
      }
      last = max;
    }
    return isPossible ? "YES" : "NO";
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    int n = in.nextInt();
    String[] grid = new String[n];
    for (int grid_i = 0; grid_i < n; grid_i++) {
      grid[grid_i] = in.next();
    }
    String result = gridChallenge(grid);
    System.out.println(result);
    in.close();
  }
}
