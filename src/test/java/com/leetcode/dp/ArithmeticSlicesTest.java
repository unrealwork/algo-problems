package com.leetcode.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArithmeticSlicesTest {

  @Test
  public void testNumberOfArithmeticSlices() {
    assertEquals(3, ArithmeticSlices.numberOfArithmeticSlices(new int[] {1, 2, 3, 4}));
  }
}
