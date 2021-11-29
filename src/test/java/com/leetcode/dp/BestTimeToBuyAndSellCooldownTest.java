package com.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

public class BestTimeToBuyAndSellCooldownTest {
  @Test
  public void testMaxProfit() {
    Assert.assertEquals(3, BestTimeToBuyAndSellCooldown.maxProfit(new int[] {1, 2, 3, 0, 2}));
  }

  @Test
  public void testMaxProfit1() {
    Assert.assertEquals(0, BestTimeToBuyAndSellCooldown.maxProfit(new int[] {1}));
  }

  @Test
  public void testMaxProfit2() {
    Assert.assertEquals(3, BestTimeToBuyAndSellCooldown.maxProfit(new int[] {2, 1, 2, 1, 0, 1, 2}));
  }

  @Test
  public void testMaxProfit3() {
    Assert.assertEquals(
        15,
        BestTimeToBuyAndSellCooldown.maxProfit(new int[] {2, 6, 8, 7, 8, 7, 9, 4, 1, 2, 4, 5, 8}));
  }

  @Test
  public void testMaxProfit4() {
    Assert.assertEquals(
        15,
        BestTimeToBuyAndSellCooldown.maxProfit(
            new int[] {3, 4, 6, 0, 3, 7, 5, 8, 2, 9, 1, 6, 6, 2}));
  }
}
