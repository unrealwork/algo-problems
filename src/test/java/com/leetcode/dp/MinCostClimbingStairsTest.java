package com.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

public class MinCostClimbingStairsTest {

  @Test
  public void testMinCostClimbingStairs() {
    Assert.assertEquals(1, MinCostClimbingStairs.minCostClimbingStairs(new int[] {0, 0, 1, 1}));
  }
}
