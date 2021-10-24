package com.hackerrank.algorithms.search;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MaximumSubarrayTest {

  @Test
  public void test() {
    Assert.assertEquals(6, MaximumSubarray.maximumSum(Arrays.asList(3L, 3L, 9L, 9L, 5L), 7));
  }
}
