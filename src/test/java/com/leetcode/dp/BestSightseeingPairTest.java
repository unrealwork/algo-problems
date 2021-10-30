package com.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

public class BestSightseeingPairTest {

  @Test
  public void maxScoreSightseeingPair() {
    Assert.assertEquals(11, BestSightseeingPair.maxScoreSightseeingPair(new int[] {8, 1, 5, 2, 6}));
  }

  @Test
  public void maxScoreSightseeingPair1() {
    Assert.assertEquals(2, BestSightseeingPair.maxScoreSightseeingPair(new int[] {1, 2}));
  }

  @Test
  public void maxScoreSightseeingPair2() {
    Assert.assertEquals(7, BestSightseeingPair.maxScoreSightseeingPair(new int[] {1, 3, 5}));
  }

  @Test
  public void maxScoreSightseeingPair3() {
    Assert.assertEquals(
        16, BestSightseeingPair.maxScoreSightseeingPair(new int[] {2, 7, 7, 2, 1, 7, 10, 4, 3, 3}));
  }
}
