package com.leetcode.ds.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MinimumOperationsToReduceTest {

    private final int[] nums;
    private final int x;
    private final int expected;

    public MinimumOperationsToReduceTest(int[] nums, int x, int expected) {
        this.nums = nums;
        this.x = x;
        this.expected = expected;
    }

    @Test
    public void testMinOperations() {
        assertEquals(expected, MinimumOperationsToReduce.minOperations(nums, x));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[] {1, 1, 4, 2, 3}, 5, 2},
                {new int[] {5, 2, 3, 1, 1}, 5, 1},
                {new int[] {3, 2, 20, 1, 1, 3}, 10, 5},
                {new int[] {8828, 9581, 49, 9818, 9974, 9869, 9991, 10000, 10000, 10000, 9999, 9993, 9904, 8819, 1231, 6309},
                        134365, 16},
                {new int[] {1, 1}, 3, -1}

        });
    }
}
