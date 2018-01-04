package com.hackerrank.algorithms.implementation;

import com.hackerrank.Solution;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class BreakingTheRecords implements Solution {

  public static int[] breakingRecords(int[] score) {
    // Complete this function
    int min = score[0];
    int max = score[0];
    int mostBreaksCount = 0;
    int leastBreaksCount = 0;
    for (int i = 1; i < score.length; i++) {
      final int s = score[i];
      if (s > max) {
        mostBreaksCount++;
        max = s;
      }
      if (s < min) {
        leastBreaksCount++;
        min = s;
      }
    }
    return new int[]{mostBreaksCount, leastBreaksCount};
  }

  public static void main(String[] args) {
    new BreakingTheRecords().solve(System.in, System.out);
  }

  @Override
  public OutputStream solve(InputStream in, PrintStream os) {
    Scanner is = new Scanner(in);
    int n = is.nextInt();
    int[] score = new int[n];
    for (int score_i = 0; score_i < n; score_i++) {
      score[score_i] = is.nextInt();
    }
    int[] result = breakingRecords(score);
    for (int i = 0; i < result.length; i++) {
      os.print(result[i] + (i != result.length - 1 ? " " : ""));
    }
    os.println("");

    is.close();
    return os;
  }
}
