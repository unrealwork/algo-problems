package com.hackerrank.algorithms.strings;

import com.hackerrank.Solution;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class GemStones implements Solution {

  static int gemstones(String[] arr) {
    // Complete this function
    Set<Integer> set = arr[0].chars().boxed().collect(Collectors.toSet());
    for (int i = 0; i < arr.length; i++) {
      set.retainAll(arr[i].chars().boxed().collect(Collectors.toSet()));
    }
    return set.size();
  }

  public static void main(String[] args) {
    new GemStones().solve(System.in, System.out);
  }

  @Override
  public OutputStream solve(InputStream is, PrintStream os) {
    Scanner in = new Scanner(is);
    int n = in.nextInt();
    String[] arr = new String[n];
    for (int arr_i = 0; arr_i < n; arr_i++) {
      arr[arr_i] = in.next();
    }
    int result = gemstones(arr);
    os.println(result);
    return os;
  }
}
