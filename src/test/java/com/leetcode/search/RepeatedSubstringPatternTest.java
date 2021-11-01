package com.leetcode.search;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RepeatedSubstringPatternTest {

  @Test
  public void testRepeatedSubstringPattern() {
    assertTrue(RepeatedSubstringPattern.repeatedSubstringPattern("abab"));
  }

  @Test
  public void testRepeatedSubstringPatter1() {
    assertFalse(RepeatedSubstringPattern.repeatedSubstringPattern("aba"));
  }

  @Test
  public void testRepeatedSubstringPatter2() {
    assertTrue(RepeatedSubstringPattern.repeatedSubstringPattern("abcabcabcabc"));
  }

  @Test
  public void testRepeatedSubstringPatter3() {
    assertTrue(RepeatedSubstringPattern.repeatedSubstringPattern("abaababaab"));
  }

  @Test
  public void testRepeatedSubstringPatter4() {
    assertFalse(RepeatedSubstringPattern.repeatedSubstringPattern("abac"));
  }
  
  @Test
  public void testRepeatedSubstringPatter5() {
    assertTrue(RepeatedSubstringPattern.repeatedSubstringPattern("abacababacab"));
  }
}
