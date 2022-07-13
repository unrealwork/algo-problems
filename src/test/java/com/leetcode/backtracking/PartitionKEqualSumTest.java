package com.leetcode.backtracking;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class PartitionKEqualSumTest {
    private final int[] nums;
    private final int k;
    private final boolean expected;

    public PartitionKEqualSumTest(int[] nums, int k, boolean expected) {
        this.nums = nums;
        this.k = k;
        this.expected = expected;
    }

    @Test
    public void canPartitionKSubsets() {
        final boolean res = PartitionKEqualSum.canPartitionKSubsets(nums, k);
        assertThat(res, equalTo(expected));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[] {4, 3, 2, 3, 5, 2, 1}, 4, true},
                {new int[] {1, 2, 3, 4}, 3, false}
        });
    }
}
