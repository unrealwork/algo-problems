package com.leetcode.binarysearch;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SearchInsertPositionTest {
    private final int[] nums;
    private final int target;
    private final int expected;

    public SearchInsertPositionTest(int[] nums, int target, int expected) {
        this.nums = nums;
        this.target = target;
        this.expected = expected;
    }


    @Test
    public void testSearchInsert() {
        Assert.assertEquals(expected, SearchInsertPosition.searchInsert(nums, target));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[] {1, 3, 5, 6}, 5, 2},
                {new int[] {1, 3, 5, 6}, 2, 1},
                {new int[] {1, 3, 5, 6}, 7, 4},
                {new int[] {1, 3, 5, 6}, -1, 0},
                {new int[] {1, 3}, -1, 0},
        });
    }
}
