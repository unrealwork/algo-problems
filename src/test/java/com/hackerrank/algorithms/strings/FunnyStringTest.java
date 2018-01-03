package com.hackerrank.algorithms.strings;

import com.hackerrank.algorithms.strings.FunnyString.Result;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FunnyStringTest {

  @Test(dataProvider = "provideSolutionData")
  public void testFunnyString(String s, String expectedResult) {
    Assert.assertEquals(FunnyString.funnyString(s), expectedResult);
  }

  @Test(dataProvider = "provideIsPalindromeData")
  public void testIsPalindrome(int[] arr, boolean expectedResult) {
    Assert.assertEquals(FunnyString.isPalindrome(arr), expectedResult);
  }

  @DataProvider()
  private Object[][] provideIsPalindromeData() {
    return new Object[][]{
        {new int[]{1, 2, 3}, false},
        {new int[]{1, 2, 1}, true},
        {new int[]{1, 2, 2, 1}, true},
        {new int[]{1, 2, 1, 1}, false},
    };
  }

  @DataProvider()
  private Object[][] provideSolutionData() {
    return new Object[][]{
        {"acxz", Result.FUNNY},
        {"bcxz", Result.NOT_FUNNY}
    };
  }
}