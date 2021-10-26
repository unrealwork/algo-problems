package com.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

public class HouseRobberBottomUpTest {

  @Test
  public void rob() {
    Assert.assertEquals(12, HouseRobberBottomUp.rob(new int[] {2, 7, 9, 3, 1}));
  }
}
