package com.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

public class BestTimeToBuyAndSellTest {

  @Test
  public void testMaxProfit() {
    Assert.assertEquals(5, BestTimeToBuyAndSell.maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
  }

  @Test
  public void testMaxProfit1() {
    Assert.assertEquals(0, BestTimeToBuyAndSell.maxProfit(new int[] {7, 6, 4, 3, 1}));
  }
}
