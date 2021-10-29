package com.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

public class MaximumCircullarSubarrayTest {

  @Test
  public void maxSubarraySumCircular() {
    Assert.assertEquals(
        4, MaximumCircullarSubarray.maxSubarraySumCircular(new int[] {3, -1, 2, -1}));
  }

  @Test
  public void maxSubarraySumCircular1() {
    Assert.assertEquals(
        3, MaximumCircullarSubarray.maxSubarraySumCircular(new int[] {1, -2, 3, -2}));
  }

  @Test
  public void maxSubarraySumCircular2() {
    Assert.assertEquals(10, MaximumCircullarSubarray.maxSubarraySumCircular(new int[] {5, -3, 5}));
  }

  @Test
  public void maxSubarraySumCircular3() {
    Assert.assertEquals(
        12, MaximumCircullarSubarray.maxSubarraySumCircular(new int[] {5, 5, 0, -5, 3, -3, 2}));
  }

  @Test
  public void maxSubarraySumCircular4() {
    Assert.assertEquals(
        18, MaximumCircullarSubarray.maxSubarraySumCircular(new int[] {9, -4, -7, 9}));
  }
}
