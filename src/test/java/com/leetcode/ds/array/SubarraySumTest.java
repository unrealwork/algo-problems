package com.leetcode.ds.array;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class SubarraySumTest {
    private final int[] nums;
    private final int k;
    private final int expected;

    public SubarraySumTest(int[] nums, int k, int expected) {
        this.nums = nums;
        this.k = k;
        this.expected = expected;
    }

    @Test
    public void testSubarraySum() {
        Assert.assertEquals(expected, SubarraySum.subarraySum(nums, k));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[] {-1, -1, 1}, 0, 1},
                {new int[] {1, 2, 3}, 3, 2},
                {new int[] {1, 1, 1}, 2, 2}
        });
    }
}
