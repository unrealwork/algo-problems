package com.stepik.algods;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TreeHeightTest {
    @Test(dataProvider = "testData")
    public static void test(final int[] tree, final int expectedHeight) {
        Assert.assertEquals(TreeHeight.solve(tree), expectedHeight);
    }

    @DataProvider
    private static Object[][] testData() {
        return new Object[][]{
                {new int[]{9, 7, 5, 5, 2, 9, 9, 9, 2, -1}, 4},
                {new int[]{4, -1, 4, 1, 1}, 3},
        };
    }
}