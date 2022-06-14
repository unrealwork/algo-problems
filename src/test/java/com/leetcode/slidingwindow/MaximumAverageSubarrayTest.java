package com.leetcode.slidingwindow;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.testng.Assert;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MaximumAverageSubarrayTest {
    private final int[] nums;
    private final int k;
    private final double expected;

    public MaximumAverageSubarrayTest(int[] nums, int k, double expected) {
        this.nums = nums;
        this.k = k;
        this.expected = expected;
    }

    @Test
    public void testFindMaxAverage() {
        Assert.assertEquals(expected, MaximumAverageSubarray.findMaxAverage(nums, k), 1e-6);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[] {1, 12, -5, -6, 50, 3}, 4, 12.75}
        });
    }
}
