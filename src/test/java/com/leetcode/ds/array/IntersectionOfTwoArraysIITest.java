package com.leetcode.ds.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class IntersectionOfTwoArraysIITest {

  @Test
  public void intersect() {
    assertArrayEquals(
        new int[] {2, 2},
        IntersectionOfTwoArraysII.intersect(new int[] {1, 2, 2, 1}, new int[] {2, 2}));
  }

  @Test
  public void intersect1() {
    assertArrayEquals(
        new int[] {4, 9},
        IntersectionOfTwoArraysII.intersect(new int[] {4, 9, 5}, new int[] {9, 4, 9, 8, 4}));
  }
  
  @Test
  public void intersect2() {
    assertArrayEquals(
        new int[] {1},
        IntersectionOfTwoArraysII.intersect(new int[] {3, 1, 2}, new int[] {1, 1}));
  }
}
