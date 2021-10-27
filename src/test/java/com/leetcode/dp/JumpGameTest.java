package com.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

public class JumpGameTest {

  @Test
  public void testCanNotJump() {
    Assert.assertFalse(JumpGame.canJump(new int[] {3, 2, 1, 0, 4}));
  }

  @Test
  public void testCanJump() {
    Assert.assertTrue(JumpGame.canJump(new int[] {2, 3, 1, 1, 4}));
  }
}
