package com.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

public class MinFallingPathSumTest {

  @Test
  public void minFallingPathSum() {
    Assert.assertEquals(
        13, MinFallingPathSum.minFallingPathSum(new int[][] {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}));
  }
}
