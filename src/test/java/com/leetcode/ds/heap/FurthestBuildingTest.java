package com.leetcode.ds.heap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.testng.Assert;

import java.util.Arrays;
import java.util.Collection;

import static com.leetcode.ds.heap.FurthestBuilding.furthestBuilding;

@RunWith(Parameterized.class)
public class FurthestBuildingTest {
    private final int[] heights;
    private final int bricks;
    private final int ladders;
    private final int expected;

    public FurthestBuildingTest(int[] heights, int bricks, int ladders, int expected) {
        this.heights = heights;
        this.ladders = ladders;
        this.bricks = bricks;
        this.expected = expected;
    }

    @Test
    public void testFurthestBuilding() {
        Assert.assertEquals(expected, furthestBuilding(heights, bricks, ladders));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][] {
                {new int[] {4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2, 7},
                {new int[] {14, 3, 19, 3}, 17, 0, 3},
                {new int[] {4, 2, 7, 6, 9, 14, 12}, 5, 1, 4}
        });
    }
}
