package com.leetcode.string;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MyAtoiTest {
  private final TestCase testCase;

  public MyAtoiTest(TestCase testCase) {
    this.testCase = testCase;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> tcs() {
    return Arrays.asList(
        new Object[][] {
          {tc(42, "42")},
          {tc(42, "             42")},
          {tc(42, "             +42")},
          {tc(-42, "             -42")},
          {tc(4193, "4193 with words")},
          {tc(0, "words and 987")},
          {tc(Integer.MIN_VALUE, "-91283472332")},
          {tc(Integer.MAX_VALUE, "91283472332")},
          {tc(Integer.MAX_VALUE, Long.toString(Integer.MAX_VALUE + 1L))},
          {tc(-Integer.MAX_VALUE, Long.toString(-Integer.MAX_VALUE))},
          {tc(Integer.MAX_VALUE, Long.toString(Integer.MIN_VALUE * (-1L)))},
          {tc(0, "")},
          {tc(-1, "-000000000000001")},
        });
  }

  public static TestCase tc(int expected, String input) {
    return new TestCase(expected, input);
  }

  @Test
  public void myAtoi() {
    Assert.assertEquals(testCase.expected, MyAtoi.myAtoi(testCase.input));
  }

  private static class TestCase {
    int expected;
    String input;

    private TestCase(int expected, String input) {
      this.expected = expected;
      this.input = input;
    }
  }
}
