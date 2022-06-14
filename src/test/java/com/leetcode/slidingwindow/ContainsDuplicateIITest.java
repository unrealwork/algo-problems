package com.leetcode.slidingwindow;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static com.leetcode.slidingwindow.ContainsDuplicateII.containsNearbyDuplicate;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ContainsDuplicateIITest {

    private final int[] nums;
    private final int k;
    private final boolean expected;

    public ContainsDuplicateIITest(int[] nums, int k, boolean expected) {
        this.nums = nums;
        this.k = k;
        this.expected = expected;
    }

    @Test
    public void testContainsNearbyDuplicate() {
        assertEquals(expected, containsNearbyDuplicate(nums, k));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[] {}, 2, false},
                {new int[] {1, 2, 3, 1}, 3, true},
                {new int[] {1, 2, 3, 1, 2, 3}, 2, false},
                {new int[] {1, 0, 1, 1}, 1, true},
                {new int[] {1, 2, 1}, 0, false}
        });
    }
}
