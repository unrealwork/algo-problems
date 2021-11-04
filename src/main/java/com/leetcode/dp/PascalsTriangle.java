package com.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
  private PascalsTriangle() {}

  public static List<List<Integer>> generate(int numRows) {
    List<List<Integer>> res = new ArrayList<>(numRows);
    for (int i = 0; i < numRows; i++) {
      List<Integer> cur = new ArrayList<>(i + 1);
      cur.add(1);
      if (i > 0) {
        List<Integer> last = res.get(i - 1);
        for (int j = 1; j < i; j++) {
          cur.add(last.get(j - 1) + last.get(j));
        }
        cur.add(1);
      }
      res.add(cur);
    }
    return res;
  }
}
