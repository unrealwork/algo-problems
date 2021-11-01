package com.leetcode.twopointers;

import org.junit.Assert;
import org.junit.Test;

public class RemoveDuplicatesTest {

  @Test
  public void testRemoveDuplicates() {
    Assert.assertEquals(2, RemoveDuplicates.removeDuplicates(new int[] {1, 1, 2}));
  }
  
  @Test
  public void testRemoveDuplicates1() {
    Assert.assertEquals(5, RemoveDuplicates.removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
  }
  
  @Test
  public void testRemoveDuplicates2() {
    Assert.assertEquals(1, RemoveDuplicates.removeDuplicates(new int[] {1,1}));
  }
  
  @Test
  public void testRemoveDuplicates3() {
    Assert.assertEquals(2, RemoveDuplicates.removeDuplicates(new int[] {1,2}));
  }
}
