package com.hackerrank.algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class CavityMap {
  static String[] cavityMap(String[] grid) {
    // Complete this function
    int n = grid.length;
    char[][] resultGrid = new char[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        char c = grid[i].charAt(j);
        if (i > 0 && i < (n - 1) && j > 0 && j < (n - 1)) {
          if (c > grid[i - 1].charAt(j) && c > grid[i + 1].charAt(j) &&
              c > grid[i].charAt(j - 1) && c > grid[i].charAt(j + 1)) {
            resultGrid[i][j] = 'X';
          } else {
            resultGrid[i][j] = c;
          }
        } else {
          resultGrid[i][j] = c;
        }
      }
    }
    return Arrays.stream(resultGrid).map(String::new).toArray(String[]::new);
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    String[] grid = new String[n];
    for (int grid_i = 0; grid_i < n; grid_i++) {
      grid[grid_i] = in.next();
    }
    String[] result = cavityMap(grid);
    for (int i = 0; i < result.length; i++) {
      System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
    }
    System.out.println("");
    in.close();
  }
}
