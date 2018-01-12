package com.hackerrank.algorithms.implementation;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ClimbingTheLeaderBoardTest {

  @Test(dataProvider = "provideLastRateData")
  public void testLastRate(int[] scores, int expectedResult) {
    Assert
        .assertEquals(ClimbingTheLeaderBoard.lastRate(scores), expectedResult);
  }

  @DataProvider
  private Object[][] provideLastRateData() {
    return new Object[][]{
        {new int[]{100, 100, 50, 40, 40, 20, 10}, 6}
    };
  }

  @Test(dataProvider = "provideLimitsData")
  public void testLimits(int[] scorese, int[] limits) {
    int rate = ClimbingTheLeaderBoard.lastRate(scorese);
    Assert.assertEquals(ClimbingTheLeaderBoard
        .limits(scorese, rate), limits);
  }

  @DataProvider
  private Object[][] provideLimitsData() {
    return new Object[][]{
        {new int[]{100, 100, 50, 40, 40, 20, 10},
            new int[]{10, 20, 40, 50, 100}}
    };
  }
}