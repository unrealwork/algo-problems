package com.leetcode.dp;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class WordBreakTest {

  @Test
  public void wordBreak() {
    assertTrue(WordBreak.wordBreak("leetcode", Arrays.asList("leet", "code")));
  }
  
  @Test
  public void wordBreak1() {
    assertTrue(WordBreak.wordBreak("aaaaaaa", Arrays.asList("aaaa","aaa")));
  }
}
