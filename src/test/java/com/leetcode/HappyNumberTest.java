package com.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HappyNumberTest {

  @Test
  public void isHappy() {
    assertTrue(HappyNumber.isHappy(19));
  }
  
  @Test
  public void isNotHappy() {
    assertFalse(HappyNumber.isHappy(2));
  }
  
  @Test
  public void isHappy1() {
    assertTrue(HappyNumber.isHappy(7));
  }
}
