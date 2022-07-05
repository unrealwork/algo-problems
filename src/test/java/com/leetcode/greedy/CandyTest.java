package com.leetcode.greedy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.testng.Assert;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CandyTest {
    private final int[] ratings;
    private final int expected;

    public CandyTest(int[] ratings, int expected) {
        this.ratings = ratings;
        this.expected = expected;
    }

    @Test
    public void testCandy() {
        Assert.assertEquals(Candy.candy(ratings), expected);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[] {1, 0, 2}, 5}
        });
    }
}
