package com.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

public class DeleteEarnBottomUpTest {

  @Test
  public void testDeleteAndEarn() {
    Assert.assertEquals(9, DeleteEarnBottomUp.deleteAndEarn(new int[] {2, 2, 3, 3, 3, 4}));
  }
}
