package com.hackerrank.algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MarkCakewalk {

  static long marcsCakewalk(int[] calorie) {
    int[] sortedCalories = Arrays.stream(calorie).sorted().toArray();
    long res = 0;
    long mult = 1;
    for (int i = sortedCalories.length - 1; i > -1; i--) {
      res += sortedCalories[i] * mult;
      mult *= 2;
    }
    return res;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] calorie = new int[n];
    for (int calorie_i = 0; calorie_i < n; calorie_i++) {
      calorie[calorie_i] = in.nextInt();
    }
    long result = marcsCakewalk(calorie);
    System.out.println(result);
    in.close();
  }
}
