package com.hackerrank.algorithms.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClimbingTheLeaderBoard {

  public static int lastRate(int[] scores) {
    int rate = 1;
    int prev = scores[0];
    for (int i = 1; i < scores.length; i++) {
      if (scores[i] < prev) {
        rate++;
        prev = scores[i];
      }
    }
    return rate + 1;
  }

  static Integer[] climbingLeaderboard(int[] scores, int[] alice) {
    // Complete this function
    int j = 0;
    int rate = lastRate(scores);
    int i = 0;
    int[] limits = limits(scores, rate);
    List<Integer> rates = new ArrayList<>();
    while (j < alice.length) {
      int currentScore = alice[j];
      while (i < (rate - 1) && limits[i] < currentScore) {
        i++;
      }
      if (i < limits.length) {
        if (currentScore == limits[i]) {
          rates.add(rate - i - 1);
        } else {
          rates.add(rate - i);
        }
      } else {
        rates.add(1);
      }
      j++;
    }
    return rates.toArray(new Integer[]{});
  }

  public static int[] limits(int[] scores, int rate) {
    int[] limits = new int[rate - 1];
    limits[0] = scores[scores.length - 1];
    int prev = limits[0];
    int j = 0;
    for (int i = scores.length - 2; i > -1; i--) {
      if (scores[i] != prev) {
        j++;
        limits[j] = scores[i];
        prev = scores[i];
      }
    }
    return limits;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] scores = new int[n];
    for (int scores_i = 0; scores_i < n; scores_i++) {
      scores[scores_i] = in.nextInt();
    }
    int m = in.nextInt();
    int[] alice = new int[m];
    for (int alice_i = 0; alice_i < m; alice_i++) {
      alice[alice_i] = in.nextInt();
    }
    Integer[] result = climbingLeaderboard(scores, alice);
    for (int i = 0; i < result.length; i++) {
      System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
    }
    System.out.println("");

    in.close();
  }
}
