package com.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

public class UniqueBSTTest {

  @Test
  public void numTrees() {
    Assert.assertEquals(5, UniqueBST.numTrees(3));
  }

  @Test
  public void numTrees1() {
    Assert.assertEquals(14, UniqueBST.numTrees(4));
  }
  
  @Test
  public void numTrees2() {
    Assert.assertEquals(132, UniqueBST.numTrees(6));
  }
}
