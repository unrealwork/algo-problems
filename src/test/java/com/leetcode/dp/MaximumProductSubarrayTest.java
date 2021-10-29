package com.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

public class MaximumProductSubarrayTest {

  @Test
  public void maxProduct() {
    Assert.assertEquals(0, MaximumProductSubarray.maxProduct(new int[] {-2, 0, -1}));
  }

  @Test
  public void maxProduct1() {
    Assert.assertEquals(6, MaximumProductSubarray.maxProduct(new int[] {2, 3, -2, 4}));
  }

  @Test
  public void maxProduct2() {
    Assert.assertEquals(4, MaximumProductSubarray.maxProduct(new int[] {3, -1, 4}));
  }

  @Test
  public void maxProduct3() {
    Assert.assertEquals(24, MaximumProductSubarray.maxProduct(new int[] {2, -5, -2, -4, 3}));
  }

  @Test
  public void maxProduct4() {
    Assert.assertEquals(
        432, MaximumProductSubarray.maxProduct(new int[] {1, -2, 3, -4, -3, -4, -3}));
  }

  @Test
  public void maxProduct5() {
    Assert.assertEquals(6, MaximumProductSubarray.maxProduct(new int[] {-1, -2, -3, 0}));
  }
  
  @Test
  public void maxProduct6() {
    Assert.assertEquals(6, MaximumProductSubarray.maxProduct(new int[] {0, -2, -3}));
  }
}
