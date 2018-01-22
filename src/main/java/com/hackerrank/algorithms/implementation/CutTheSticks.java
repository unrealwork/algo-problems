package com.hackerrank.algorithms.implementation;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CutTheSticks {

  static int[] cutTheSticks(int[] arr) {
    // Complete this function
    Map<Integer, Long> dict = Arrays.stream(arr).boxed()
        .collect(Collectors.groupingBy(
            Function.identity(), Collectors.counting()));
    int start = arr.length;
    final List<Integer> res = new ArrayList<>();
    List<Integer> soredSet = dict.keySet().stream().sorted().collect(toList());
    for (int n : soredSet) {
      res.add(start);
      start -= dict.get(n);
    }
    return res.stream().mapToInt(Integer::intValue).toArray();
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] arr = new int[n];
    for (int arr_i = 0; arr_i < n; arr_i++) {
      arr[arr_i] = in.nextInt();
    }
    int[] result = cutTheSticks(arr);
    for (int i = 0; i < result.length; i++) {
      System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
    }
    System.out.println("");

    in.close();
  }
}
