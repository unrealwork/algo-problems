package com.hackerrank.algorithms.recursion;

import com.hackerrank.Solution;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.stream.IntStream;

public class PowerSum implements Solution {


  @Override
  public OutputStream solve(InputStream is, PrintStream os) {
    Scanner in = new Scanner(is);
    int X = in.nextInt();
    int N = in.nextInt();
    int result = powerSum(X, N);
    os.println(result);
    in.close();
    return os;
  }

  private int powerSum(int x, int n) {
    int count = 0;
    int limit = (int) Math.sqrt(x);
    int[] powers = IntStream.rangeClosed(1, limit)
        .map(i -> powermod(i, n)).toArray();
    return countCombination(x, 0, powers, count, 0);

  }


  private static int countCombination(int x, int sum, int[] powers, int count,
      int index) {
    if (sum <= x) {
      if (sum == x) {
        return count + 1;
      } else {
        int res = 0;
        for (int i = index; i < powers.length; i++) {
          res += countCombination(x, sum + powers[i], powers, count, i + 1);
        }
        return res;
      }
    }
    return 0;
  }

  public static int powermod(int base, int exponent) {
    int result = 1;
    while (exponent > 0) {
      if ((exponent % 2) == 1) {
        result = (result * base);
      }
      base = (base * base);
      exponent = exponent / 2;
    }
    return result;
  }

  public static void main(String[] args) {
    new PowerSum().solve(System.in, System.out);
  }
}
