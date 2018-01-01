package com.hackerrank.algorithms.sorting;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FullCountingSort {


  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    List<String>[] holder = new List[10];
    for (int i = 0; i < 10; i++) {
      holder[i] = new LinkedList<String>();
    }
    for (int a0 = 0; a0 < n; a0++) {
      int x = in.nextInt();
      String s = in.next();
      if (a0 < n / 2) {
        s = "-";
      }
      holder[x].add(s);
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < holder.length; i++) {
      sb.append(holder[i].stream().collect(
          Collectors.joining(" ", "", " ")));
    }
    System.out.println(sb.toString());
    in.close();
  }
}
