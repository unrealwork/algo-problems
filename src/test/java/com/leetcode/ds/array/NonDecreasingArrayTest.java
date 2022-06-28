package com.leetcode.ds.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.testng.Assert;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class NonDecreasingArrayTest {
    private final int[] nums;
    private final boolean expected;

    public NonDecreasingArrayTest(int[] nums, boolean expected) {
        this.nums = nums;
        this.expected = expected;
    }

    @Test
    public void testCheckPossibility() {
        Assert.assertEquals(expected, NonDecreasingArray.checkPossibility(nums));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[] {-1, 4, 2, 3}, true},
                {new int[] {4, 2, 3}, true},
                {new int[] {4, 2, 1}, false},
                {new int[] {3, 4, 2, 3}, false}
        });
    }
}
