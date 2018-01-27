package com.hackerrank.contest.hiringcontest;

import java.util.Scanner;

public class ProgrammingCompetition {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    String best = in.next();
    int d = in.nextInt();
    int j = in.nextInt();
    int maxScore = j - d;
    for (int a0 = 1; a0 < n; a0++) {
      String name = in.next();
      int decemberScore = in.nextInt();
      int januaryScore = in.nextInt();
      int score = januaryScore - decemberScore;
      if (score > maxScore) {
        best = name;
        maxScore = score;
      }
    }
    System.out.println(best + " " + maxScore);
    // Write Your Code Here
    in.close();
  }
}
