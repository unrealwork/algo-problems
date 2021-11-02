package com.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

public class DecodeWaysTest {

  @Test
  public void numDecodings() {
    Assert.assertEquals(2, DecodeWays.numDecodings("12"));
  }
  
  @Test
  public void numDecodings1() {
    Assert.assertEquals(3, DecodeWays.numDecodings("226"));
  }
  @Test
  public void numDecodings2() {
    Assert.assertEquals(0, DecodeWays.numDecodings("0"));
  }
  
  @Test
  public void numDecodings3() {
    Assert.assertEquals(0, DecodeWays.numDecodings("06"));
  }
  @Test
  public void numDecodings4() {
    Assert.assertEquals(1, DecodeWays.numDecodings("27"));
  }
  
  @Test
  public void numDecodings5() {
    Assert.assertEquals(1, DecodeWays.numDecodings("10"));
  }
  
  @Test
  public void numDecodings6() {
    Assert.assertEquals(1, DecodeWays.numDecodings("2101"));
  }
}
