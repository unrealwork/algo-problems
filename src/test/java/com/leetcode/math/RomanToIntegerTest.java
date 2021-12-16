package com.leetcode.math;

import org.junit.Assert;
import org.junit.Test;

public class RomanToIntegerTest {

  @Test
  public void testRomanToInt() {
    Assert.assertEquals(RomanToInteger.romanToInt("MCMXCIV"), 1994);
  }

  @Test
  public void testRomanToInt1() {
    Assert.assertEquals(RomanToInteger.romanToInt("III"), 3);
  }

  @Test
  public void testRomanToInt2() {
    Assert.assertEquals(RomanToInteger.romanToInt("LVIII"), 58);
  }
  
  @Test
  public void testRomanToInt3() {
    Assert.assertEquals(RomanToInteger.romanToInt("L"), 50);
  }
}
