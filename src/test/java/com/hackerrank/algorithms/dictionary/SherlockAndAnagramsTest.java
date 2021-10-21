package com.hackerrank.algorithms.dictionary;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SherlockAndAnagramsTest {
  private final TestCase testCase;

  public SherlockAndAnagramsTest(TestCase testCase) {
    this.testCase = testCase;
  }
  
  @Parameterized.Parameters
  public static Collection<Object[]> testCases() {
    return Arrays.asList(new Object[][] {
            {TestCase.testCase(4, "abba")},
            {TestCase.testCase(2, "mom")},
            {TestCase.testCase(3, "ifailuhkqq")},
            {TestCase.testCase(10, "kkkk")},
    });
  }

  @Test
  public void sherlockAndAnagrams() {
    Assert.assertEquals(testCase.expected, SherlockAndAnagrams.sherlockAndAnagrams(testCase.s));
  }

  private static class TestCase {
    private final int expected;
    private final String s;

    private TestCase(int expected, String s) {
      this.expected = expected;
      this.s = s;
    }

    private static TestCase testCase(int expected, String s) {
      return new TestCase(expected, s);
    }
  }
}
