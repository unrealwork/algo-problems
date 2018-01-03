package com.hackerrank.contest;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// TODO: Unsolved, find and figure out correct solution.
public class MaximumPalindromes {

  private static String source;

  static void initialize(String s) {
    source = s;
  }

  static BigInteger answerQuery(int l, int r) {
    // Return the answer for this query modulo 1000000007.
    Map<Character, Integer> dict = new HashMap<>();
    for (int i = l - 1; i < r; i++) {
      char c = source.charAt(i);
      if (dict.containsKey(c)) {
        dict.put(c, dict.get(c) + 1);
      } else {
        dict.put(c, 1);
      }
    }
    int factor = 0;
    int maxOdd = -1;
    List<Integer> evens = new ArrayList<>();
    for (Map.Entry<Character, Integer> e : dict.entrySet()) {
      Integer value = e.getValue();
      if (value % 2 == 0) {
        evens.add(value / 2);
      } else {
        if (value > maxOdd) {
          maxOdd = value;
        }
      }
    }
    for (Map.Entry<Character, Integer> e : dict.entrySet()) {
      Integer value = e.getValue();
      if (value == maxOdd) {
        factor++;
      }
    }
    if (maxOdd > 1) {
      evens.add(((maxOdd - 1) / 2));
    }
    if (maxOdd < 0 && evens.size() == 0) {
      return BigInteger.ZERO;
    } else {
      BigInteger res = BigInteger.ONE;
      for (int j = 1; j <= evens.size(); j++) {
        res = res.multiply(BigInteger.valueOf(j));
      }
      for (Integer evenHalf : evens) {
        for (int k = 2; k <= evenHalf; k++) {
          res = res.divide(BigInteger.valueOf(k));
        }
      }
      if (factor > 1) {
        res = res.multiply(BigInteger.valueOf(factor));
      }
      return res;
    }
  }


  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.next();
    initialize(s);
    int q = in.nextInt();
    for (int a0 = 0; a0 < q; a0++) {
      int l = in.nextInt();
      int r = in.nextInt();
      int result = answerQuery(l, r).intValue();
      System.out.println(result);
    }
    in.close();
  }
}
