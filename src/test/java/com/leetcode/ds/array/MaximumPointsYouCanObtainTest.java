package com.leetcode.ds.array;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MaximumPointsYouCanObtainTest {
    private final int[] nums;
    private final int k;
    private final int expected;

    public MaximumPointsYouCanObtainTest(int[] nums, int k, int expected) {
        this.nums = nums;
        this.k = k;
        this.expected = expected;
    }


    @Test
    public void testMaxScore() {
        int actual = MaximumPointsYouCanObtain.maxScore(nums, k);
        Assert.assertEquals(expected, actual);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[] {100, 40, 17, 9, 73, 75}, 3, 248}
        });
    }
}
