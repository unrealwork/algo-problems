package com.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

public class MaximumProductSubarrayLengthTest {

  @Test
  public void testGetMaxLen() {
    Assert.assertEquals(4, MaximumProductSubarrayLength.getMaxLen(new int[] {1, -2, -3, 4}));
  }

  @Test
  public void testGetMaxLen1() {
    Assert.assertEquals(3, MaximumProductSubarrayLength.getMaxLen(new int[] {0, 1, -2, -3, -4}));
  }

  @Test
  public void testGetMaxLen2() {
    Assert.assertEquals(2, MaximumProductSubarrayLength.getMaxLen(new int[] {-1, -2, -3, 0, 1}));
  }

  @Test
  public void testGetMaxLen3() {
    Assert.assertEquals(1, MaximumProductSubarrayLength.getMaxLen(new int[] {-1, 2}));
  }

  @Test
  public void testGetMaxLen4() {
    Assert.assertEquals(
        4, MaximumProductSubarrayLength.getMaxLen(new int[] {1, 2, 3, 5, -6, 4, 0, 10}));
  }

  @Test
  public void testGetMaxLen5() {
    Assert.assertEquals(0, MaximumProductSubarrayLength.getMaxLen(new int[] {-1}));
  }

  @Test
  public void testGetMaxLen6() {
    Assert.assertEquals(
        11,
        MaximumProductSubarrayLength.getMaxLen(
            new int[] {9, 10, 1, 0, 19, 20, -28, 30, -12, 20, 11, -8, 7, 21, -26}));
  }

  @Test
  public void testGetMaxLen7() {
    Assert.assertEquals(
        8,
        MaximumProductSubarrayLength.getMaxLen(
            new int[] {
              5, -20, -20, -39, -5, 0, 0, 0, 36, -32, 0, -7, -10, -7, 21, 20, -12, -34, 26, 2
            }));
  }
}
