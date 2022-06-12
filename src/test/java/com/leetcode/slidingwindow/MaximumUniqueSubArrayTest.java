package com.leetcode.slidingwindow;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MaximumUniqueSubArrayTest {
    private final int[] nums;
    private final int expected;

    public MaximumUniqueSubArrayTest(int[] nums, int expected) {
        this.nums = nums;
        this.expected = expected;
    }

    @Test
    public void maximumUniqueSubarray() {
        Assert.assertEquals(expected, MaximumUniqueSubArray.maximumUniqueSubarray(nums));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[] {4, 2, 4, 5, 6}, 17},
                {new int[] {5, 2, 1, 2, 5, 2, 1, 2, 5}, 8}
        });
    }
}
