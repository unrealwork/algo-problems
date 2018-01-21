package com.hackerrank.algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class LuckContest {

  static int luckBalance(int n, int k, int[][] contests) {
    // Complete this function
    int unimportant = Arrays.stream(contests).filter(c -> c[1] == 0)
        .mapToInt(c -> c[0]).sum();
    int[] important = Arrays.stream(contests).filter(c -> c[1] == 1)
        .map(c -> c[0]).sorted((a, b) -> -Integer.compare(a, b))
        .mapToInt(Integer::intValue).toArray();
    int sum = 0;
    for (int i = 0; i < important.length; i++) {
      if (i < k) {
        sum += important[i];
      } else {
        sum -= important[i];
      }
    }
    return sum + unimportant;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    int[][] contests = new int[n][2];
    for (int contests_i = 0; contests_i < n; contests_i++) {
      for (int contests_j = 0; contests_j < 2; contests_j++) {
        contests[contests_i][contests_j] = in.nextInt();
      }
    }
    int result = luckBalance(n, k, contests);
    System.out.println(result);
    in.close();
  }
}
