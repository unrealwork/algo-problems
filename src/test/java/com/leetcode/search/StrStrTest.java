package com.leetcode.search;

import org.junit.Assert;
import org.junit.Test;

public class StrStrTest {

  @Test
  public void strStr() {
    Assert.assertEquals(2, StrStr.strStr("hello", "ll"));
  }
  
  @Test
  public void strStr1() {
    Assert.assertEquals(0, StrStr.strStr("", ""));
  }
  
  @Test
  public void strStr2() {
    Assert.assertEquals(-1, StrStr.strStr("aaaaa", "bba"));
  }
  
  @Test
  public void strStr3() {
    Assert.assertEquals(4, StrStr.strStr("aabaaabaaac", "aabaaac"));
  }
  
}
