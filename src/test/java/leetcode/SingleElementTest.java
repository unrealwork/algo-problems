package leetcode;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SingleElementTest {

  @Test(dataProvider = "provideCases")
  public void testSingleNonDuplicate(int[] nums, int expectedNumber)
      throws Exception {
    Assert.assertEquals(SingleElement.singleNonDuplicate(nums), expectedNumber);
  }

  @DataProvider
  private Object[][] provideCases() {
    return new Object[][]{
        {new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}, 2},
        {new int[]{3, 3, 7, 7, 10, 11, 11}, 10},
        {new int[]{1, 1, 2}, 2},
        {new int[]{1, 2, 2}, 1},
        {new int[]{2}, 2},
        {new int[]{1, 1, 2, 2, 4, 4, 5, 5, 9}, 9},
        {new int[]{0, 1, 1, 2, 2, 5, 5}, 0}
    };
  }
}