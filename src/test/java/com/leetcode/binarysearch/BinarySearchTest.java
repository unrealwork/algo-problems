package com.leetcode.binarysearch;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {

  @Test
  public void testSearch() {
    Assert.assertEquals(4, BinarySearch.search(new int[] {-1, 0, 3, 5, 9, 12}, 9));
  }

  @Test
  public void testSearch1() {
    Assert.assertEquals(-1, BinarySearch.search(new int[] {-1, 0, 3, 5, 9, 12}, 2));
  }
}
