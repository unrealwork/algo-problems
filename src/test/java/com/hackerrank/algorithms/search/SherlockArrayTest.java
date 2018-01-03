package com.hackerrank.algorithms.search;

import com.hackerrank.algorithms.search.SherlockArray.Result;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SherlockArrayTest {

  @Test(dataProvider = "provideSolutionData")
  public void testSolve(int[] arr, String expectedResult) {
    Assert.assertEquals(SherlockArray.solve(arr), expectedResult);
  }

  @DataProvider
  public Object[][] provideSolutionData() {
    return new Object[][]{
        {new int[]{1, 2, 3}, Result.NO},
        {new int[]{1, 2, 3, 3}, Result.YES},
    };
  }
}