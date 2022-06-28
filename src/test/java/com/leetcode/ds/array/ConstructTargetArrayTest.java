package com.leetcode.ds.array;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ConstructTargetArrayTest {
    private final int[] nums;
    private final boolean expected;

    public ConstructTargetArrayTest(int[] nums, boolean expected) {
        this.nums = nums;
        this.expected = expected;
    }

    @Test
    public void isPossible() {
        Assert.assertEquals(expected, ConstructTargetArray.isPossible(nums));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[] {9, 3, 5}, true},
                {new int[] {1, 1, 1, 2}, false},
                {new int[] {8, 5}, true},
                {new int[] {1, 100000000}, true},
                {new int[] {1, 1, 10}, false}
        });
    }
}
