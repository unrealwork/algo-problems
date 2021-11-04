package com.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
  private PascalsTriangleII() {}

  public static List<Integer> getRow(int numRows) {
    List<Integer> res = new ArrayList<>(numRows + 1);
    List<Integer> tmp = new ArrayList<>(numRows + 1);
    for (int i = 0; i <= numRows; i++) {
      tmp.add(1);
      if (i > 0) {
        for (int j = 1; j < i; j++) {
          tmp.add(res.get(j - 1) + res.get(j));
        }
        tmp.add(1);
      }
      res.clear();
      res.addAll(tmp);
      tmp.clear();
    }
    return res;
  }
}
