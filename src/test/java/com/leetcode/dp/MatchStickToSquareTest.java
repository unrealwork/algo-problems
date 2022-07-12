package com.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MatchStickToSquareTest {
    private final int[] matchsticks;
    private final boolean expected;

    public MatchStickToSquareTest(int[] matchsticks, boolean expected) {
        this.matchsticks = matchsticks;
        this.expected = expected;
    }

    @Test
    public void testMakesquare() {
        boolean actual = MatchStickToSquare.makesquare(matchsticks);
        Assert.assertEquals(expected, actual);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[] {1, 1, 2, 2, 2}, true},
                {new int[] {3, 3, 3, 3, 4}, false},
                {new int[] {5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3}, true},
                {new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 102}, false},
                {new int[] {4, 13, 1, 1, 14, 15, 1, 3, 13, 1, 3, 5, 2, 8, 12}, false}
        });
    }
}
