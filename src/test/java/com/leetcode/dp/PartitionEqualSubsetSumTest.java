package com.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

public class PartitionEqualSubsetSumTest {

  @Test
  public void canPartition() {
    Assert.assertTrue(PartitionEqualSubsetSum.canPartition(new int[] {1, 5, 11, 5}));
  }
}
