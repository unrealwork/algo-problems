package com.hackerrank.algorithms.implementation;

import java.text.MessageFormat;
import java.util.Arrays;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BetweenTwoSetsTest {

  @Test(dataProvider = "provideGcdData")
  public void testGcd(int[] arr, int expectedResult) {
    final String assertMessage = MessageFormat
        .format("GCD of {0} should be {1}",
            Arrays.toString(arr), expectedResult);
    Assert.assertEquals(BetweenTwoSets.gcd(arr), expectedResult, assertMessage);
  }

  @Test(dataProvider = "provideLcmData")
  public void testLcm(int[] arr, long expectedResult) {
    final String assertMessage = MessageFormat
        .format("LCM of {0} should be {1}",
            Arrays.toString(arr), expectedResult);
    Assert.assertEquals(BetweenTwoSets.lcm(arr), expectedResult, assertMessage);
  }

  @Test(dataProvider = "providePowerOfTwoData")
  public void testIsPowerOfTwo(long l, boolean expectedResult) {
    final String assertMessage = MessageFormat
        .format(
            "{0} should " + (expectedResult ? "" : "not")
                + " be power of two",
            l, expectedResult);
    Assert.assertEquals(BetweenTwoSets.isPowerOfTwo(l), expectedResult,
        assertMessage);
  }


  @Test(dataProvider = "provideSolutionData")
  public void testSolve(int[] a, int[] b, int expectedResult) {
    Assert.assertEquals(BetweenTwoSets.solve(a, b), expectedResult);
  }

  @DataProvider()
  private Object[][] provideGcdData() {
    return new Object[][]{
        {new int[]{3, 6, 4}, 1},
        {new int[]{3, 6}, 3},
        {new int[]{18, 21, 72}, 3},
        {new int[]{100, 99, 98, 97, 96, 95, 94, 93, 92, 91}, 1}
    };
  }

  @DataProvider()
  private Object[][] provideLcmData() {
    return new Object[][]{
        {new int[]{3, 6, 4}, 12L},
        {new int[]{100, 99, 98, 97, 96, 95, 94, 93, 92, 91},
            BetweenTwoSets.LIMIT}
    };
  }

  @DataProvider()
  private Object[][] providePowerOfTwoData() {
    return new Object[][]{
        {2, true},
        {7, false},
        {128, true},
        {256, true}
    };
  }

  @DataProvider()
  private Object[][] provideSolutionData() {
    return new Object[][]{
        {
            new int[]{2, 4},
            new int[]{16, 32, 96},
            3
        },
        {
            new int[]{100, 99, 98, 97, 96, 95, 94, 93, 92, 91},
            new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            0
        },
        {
            new int[]{1},
            new int[]{100},
            9
        }
    };
  }
}