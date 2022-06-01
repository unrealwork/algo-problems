package com.leetcode.ds.array;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SlidingWindowMaximumTest {

    @Test
    public void testMaxSlidingWindow() {
        int[] actual = SlidingWindowMaximum.maxSlidingWindow(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3);
        Assert.assertArrayEquals(new int[] {3, 3, 5, 5, 6, 7},
                actual);
    }

    @Test
    public void testMaxSlidingWindow1() {
        int[] actual = SlidingWindowMaximum.maxSlidingWindow(new int[] {1}, 1);
        Assert.assertArrayEquals(new int[] {1},
                actual);
    }

    @Test
    public void testMaxSlidingWindow2() {
        int[] actual = SlidingWindowMaximum.maxSlidingWindow(new int[] {9, 10, 9, -7, -4, -8, 2, -6}, 5);
        Assert.assertArrayEquals(new int[] {10, 10, 9, 2},
                actual);
    }
}
