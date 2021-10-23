package com.hackerrank.algorithms.search;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MinimumLossTest {
  @Test
  public void test() {
    final long actual = MinimumLoss.minimumLoss(Arrays.asList(20L, 7L, 8L, 2L, 5L));
    Assert.assertEquals(2, actual);
  }
}
