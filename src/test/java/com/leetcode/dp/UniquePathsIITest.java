package com.leetcode.dp;

import junit.framework.TestCase;
import org.junit.Assert;

public class UniquePathsIITest extends TestCase {

    public void testUniquePathsWithObstacles() {
        Assert.assertEquals(2, UniquePathsII.uniquePathsWithObstacles(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        }));
    }
}
