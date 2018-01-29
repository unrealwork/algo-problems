package com.hackerrank.algorithms.implementation;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EqualizeArray {

  static long equalizeArray(int[] arr) {
    // Complete this function
    Map<Integer, Long> collect = Arrays.stream(arr).boxed().collect(
        Collectors.groupingBy(Function.identity(), Collectors.counting()));
    return arr.length - Collections.max(collect.values());
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] arr = new int[n];
    for (int arr_i = 0; arr_i < n; arr_i++) {
      arr[arr_i] = in.nextInt();
    }
    long result = equalizeArray(arr);
    System.out.println(result);
    in.close();
  }
}
