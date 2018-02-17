package com.leetcode;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SimplifyPathTest {

  @Test(dataProvider = "providePaths")
  public void testSimplifyPath(String path, String normailized) {
    Assert.assertEquals(SimplifyPath.simplifyPath(path), normailized);
  }

  @DataProvider
  private Object[][] providePaths() {
    return new Object[][]{
        {"/home/", "/home"},
        {"/a/./b/../../c/", "/c"},
        {"/../", "/"},
        {"/home//foo/", "/home/foo"},
        {"/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///",
            "/e/f/g"},
    };
  }
}