package com.leetcode.string;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static com.leetcode.string.LongestSubstringWithoutRepeats.lengthOfLongestSubstring;

@RunWith(Parameterized.class)
public class LongestSubstringWithoutRepeatsTest {

  private final TestCase testCase;

  public LongestSubstringWithoutRepeatsTest(TestCase testCase) {
    this.testCase = testCase;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> tcs() {
    return Arrays.asList(
        new Object[][] {
          {tc("abcabcbb", 3)}, {tc("bbbbb", 1)}, {tc("pwwkew", 3)}, {tc("dvdf", 3)}, {tc("abba", 2)}
        });
  }

  private static TestCase tc(String s, int nonRepeatingLength) {
    return new TestCase(s, nonRepeatingLength);
  }

  @Test
  public void testLengthOfLongestSubstring() {
    final int actual = lengthOfLongestSubstring(testCase.s);
    Assert.assertEquals(testCase.nonRepeatingLength, actual);
  }

  private static class TestCase {
    private final String s;
    private final int nonRepeatingLength;

    private TestCase(String s, int nonRepeatingLength) {
      this.s = s;
      this.nonRepeatingLength = nonRepeatingLength;
    }
  }
}
