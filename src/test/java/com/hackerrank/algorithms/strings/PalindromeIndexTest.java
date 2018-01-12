package com.hackerrank.algorithms.strings;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PalindromeIndexTest {

  @Test(dataProvider = "provideData")
  public void testPalindromeIndex(String s, int expectedResult)
      throws Exception {
    Assert.assertEquals(PalindromeIndex.palindromeIndex(s), expectedResult);
  }

  @DataProvider
  private Object[][] provideData() {
    return new Object[][]{
        {"quyjjdcgsvvsgcdjjyq", 1},
        {"fgnfnidynhxebxxxfmxixhsruldhsaobhlcggchboashdlurshxixmfxxxbexhnydinfngf",
            33}
    };
  }
}