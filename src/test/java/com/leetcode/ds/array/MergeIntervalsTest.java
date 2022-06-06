package com.leetcode.ds.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeIntervalsTest {

    @Test
    public void testIsOverlap() {
        assertTrue(MergeIntervals.isOverlap(new int[] {1, 4}, new int[] {0, 4}));
    }

    @Test
    public void testMerge() {
        assertArrayEquals(new int[] {0, 4}, MergeIntervals.merge(new int[] {1, 4}, new int[] {0, 4}));
    }

    @Test
    public void testMergeMultiple() {
        assertArrayEquals(new int[][]{{0, 4}}, MergeIntervals.merge(new int[][]{{1, 4}, {0, 4}}));
    }
}
