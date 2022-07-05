package com.leetcode.ds.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.testng.Assert;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LongestConsecutiveSeqTest {
    private final int[] nums;
    private final int expected;

    public LongestConsecutiveSeqTest(int[] nums, int expected) {
        this.nums = nums;
        this.expected = expected;
    }

    @Test
    public void testLongestConsecutive() {
        Assert.assertEquals(expected, LongestConsecutiveSeq.longestConsecutive(nums));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[] {200, 1, 100, 3, 2, 4}, 4},
                {new int[] {0, 3, 7, 2, 5, 8, 4, 6, 0, 1}, 9}
        });
    }
}
