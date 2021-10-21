package com.hackerrank.algorithms.dynamic;

import java.util.Arrays;
import java.util.function.BooleanSupplier;

/**
 * You can perform the following operations on the string :
 *
 * <p>Capitalize zero or more of a's lowercase letters. Delete all of the remaining lowercase
 * letters in . Given two strings, and , determine if it's possible to make equal to as described.
 * If so, print YES on a new line. Otherwise, print NO.
 *
 * @see <a href="https://www.hackerrank.com/challenges/abbr/problem">Abbreviation</a>
 */
public class Abbreviation {
  private Abbreviation() {}

  public static String abbreviation(String a, String b) {
    // Write your code here
    final int[] dp = new int[b.length()];
    Arrays.fill(dp, -1);
    final Solver solver = new Solver(a, b);
    return solver.solve(0, 0) ? "YES" : "NO";
  }

  private static class Solver {
    private final String a;
    private final String b;
    private final Boolean[][] memo;

    private Solver(String a, String b) {
      this.a = a;
      this.b = b;
      this.memo = new Boolean[b.length() + 1][a.length() + 1];
    }

    private boolean memoized(int bIndex, int aIndex, BooleanSupplier supplier) {
      if (memo[bIndex][aIndex] == null) {
        memo[bIndex][aIndex] = supplier.getAsBoolean();
      }
      return memo[bIndex][aIndex];
    }

    public boolean solve(int bIndex, int aIndex) {
      if (memo[bIndex][aIndex] != null) {
        return memo[bIndex][aIndex];
      }
      return memoized(
          bIndex,
          aIndex,
          () -> {
            if (aIndex == a.length()) {
              return bIndex == b.length();
            }
            final char aSymbol = a.charAt(aIndex);
            if (bIndex == b.length()) {
              return Character.isLowerCase(aSymbol) && solve(bIndex, aIndex + 1);
            }
            final char bSymbol = b.charAt(bIndex);

            if (Character.isLowerCase(aSymbol)) {
              if (Character.toUpperCase(aSymbol) == bSymbol) {
                return solve(bIndex + 1, aIndex + 1) || solve(bIndex, aIndex + 1);
              }
              return solve(bIndex, aIndex + 1);
            } else {
              return aSymbol == bSymbol && solve(bIndex + 1, aIndex + 1);
            }
          });
    }
  }
}
