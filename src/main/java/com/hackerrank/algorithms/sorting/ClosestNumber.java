package com.hackerrank.algorithms.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ClosestNumber {

  static class Pair {

    private int first;
    private int second;

    Pair(int a, int b) {
      this.first = a;
      this.second = b;
    }

    public int getFirst() {
      return first;
    }

    public int getSecond() {
      return second;
    }

    @Override

    public String toString() {
      return String.format("%d %d", first, second);
    }
  }

  static class PairUtils {

    static int abs(Pair p) {
      return Math.abs(p.getFirst() - p.getSecond());
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    reader.readLine();
    int[] sorted = Arrays.stream(reader.readLine().split("\\s"))
        .mapToInt(Integer::parseInt).sorted().toArray();
    solve(sorted).forEach(p -> System.out.printf("%s ", p));
  }

  private static List<Pair> solve(int[] sorted) {
    List<Pair> pairs = new ArrayList<>(sorted.length - 1);
    for (int i = 1; i < sorted.length; i++) {
      pairs.add(new Pair(sorted[i - 1], sorted[i]));
    }
    int minDiff = pairs.stream().mapToInt(PairUtils::abs).min().orElse(0);
    return pairs.stream()
        .filter(pair -> PairUtils.abs(pair) == minDiff)
        .collect(Collectors.toList());
  }
}
