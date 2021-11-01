package com.leetcode.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BooleanSupplier;

public class WordBreak {
  private WordBreak() {}

  public static boolean wordBreak(String s, List<String> wordDict) {
    return new Solver(wordDict, s).solve();
  }

  private static final class Solver {
    private final Set<String> dict;
    private final String s;
    private final Boolean[] memo;

    private Solver(List<String> dict, String s) {
      this.dict = new HashSet<>(dict);
      this.s = s;
      this.memo = new Boolean[s.length() + 1];
    }

    private boolean memoize(int index, BooleanSupplier resSupplier) {
      if (memo[index] == null) {
        memo[index] = resSupplier.getAsBoolean();
      }
      return memo[index];
    }

    public boolean solve() {
      return solve(0);
    }

    private boolean solve(int startIndex) {
      if (startIndex == s.length()) {
        return true;
      }
      StringBuilder sb = new StringBuilder();
      for (int i = startIndex; i < s.length(); i++) {
        sb.append(s.charAt(i));
        if (dict.contains(sb.toString())) {
          final int index = i + 1;
          final boolean res = memoize(index, () -> solve(index));
          if (res) {
            return res;
          }
        }
      }
      return false;
    }
  }
}
