package com.hackerrank.algorithms.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MaximumPerimeterTriangle {

  static class Triangle implements Comparable<Triangle> {

    private int a;
    private int b;
    private int c;

    Triangle(int a, int b, int c) {
      this.a = a;
      this.b = b;
      this.c = c;
    }

    private int longestSide() {
      return Collections.max(Arrays.asList(a, b, c));
    }

    private int lowestSide() {
      return Collections.min(Arrays.asList(a, b, c));
    }


    public int perimeter() {
      return a + b + c;
    }


    public boolean isValid() {
      int[] sides = sides();
      return sides[2] < sides[0] + sides[1];
    }

    public int[] sides() {
      return IntStream.of(a, b, c).sorted().toArray();
    }

    @Override
    public int compareTo(Triangle t) {
      int res = Double.compare(perimeter(), t.perimeter());
      if (res != 0) {
        return res;
      } else {
        res = Double.compare(longestSide(), lowestSide());
        if (res != 0) {
          return res;
        } else {
          return Double.compare(lowestSide(), lowestSide());
        }
      }
    }
  }

  static Optional<Triangle> maximumPerimeterTriangle(int[] l) {
    // Complete this function
    List<Triangle> list = new ArrayList<>();
    for (int i = 0; i < l.length - 2; i++) {
      for (int j = i + 1; j < l.length - 1; j++) {
        for (int k = j + 1; k < l.length; k++) {
          Triangle t = new Triangle(l[i], l[j], l[k]);
          if (t.isValid()) {
            list.add(t);
          }
        }
      }
    }
    return (list.isEmpty()) ? Optional.empty()
        : Optional.of(Collections.max(list));
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] l = new int[n];
    for (int l_i = 0; l_i < n; l_i++) {
      l[l_i] = in.nextInt();
    }
    Optional<Triangle> t = maximumPerimeterTriangle(l);
    if (t.isPresent()) {
      int[] result = t.get().sides();
      for (int i = 0; i < result.length; i++) {
        System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
      }
      System.out.println("");
    } else {
      System.out.println("-1");
    }
    in.close();
  }
}
