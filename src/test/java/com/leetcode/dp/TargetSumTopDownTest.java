package com.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

public class TargetSumTopDownTest {

  @Test
  public void findTargetSumWays() {
    Assert.assertEquals(5, TargetSumTopDown.findTargetSumWays(new int[] {1, 1, 1, 1, 1}, 3));
  }
}
