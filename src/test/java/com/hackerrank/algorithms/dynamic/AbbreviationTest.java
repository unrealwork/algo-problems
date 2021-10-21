package com.hackerrank.algorithms.dynamic;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class AbbreviationTest {
  private final TestCase testCase;

  public AbbreviationTest(TestCase testCase) {
    this.testCase = testCase;
  }

  private static TestCase tc(String expected, String a, String b) {
    return new TestCase(expected, a, b);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> tcs() {
    return Arrays.asList(
        new Object[][] {
          {tc("YES", "daBcd", "ABC")},
          {tc("YES", "AbcDE", "ABDE")},
          {tc("NO", "AbcDE", "AFDE")},
          {tc("NO", "beFgH", "EFG")}
        });
  }

  @Test
  public void testAbbreviation() {
    Assert.assertEquals(testCase.expected, Abbreviation.abbreviation(testCase.a, testCase.b));
  }

  private static class TestCase {
    private final String expected;
    private final String a;
    private final String b;

    private TestCase(String expected, String a, String b) {
      this.expected = expected;
      this.a = a;
      this.b = b;
    }
  }
}
