package com.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

public class JumpGameIITest {

  @Test
  public void testJump() {
    Assert.assertEquals(2, JumpGameII.jump(new int[] {2, 3, 1, 1, 4}));
  }

  @Test
  public void testJump1() {
    Assert.assertEquals(2, JumpGameII.jump(new int[] {2, 3, 0, 1, 4}));
  }
}
