package com.leetcode.dp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.testng.Assert;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class WiggleSubSequenceTest {
    private final int[] seq;
    private final int expected;

    public WiggleSubSequenceTest(int[] seq, int expected) {
        this.seq = seq;
        this.expected = expected;
    }

    @Test
    public void testWiggleMaxLength() {
        Assert.assertEquals(expected, WiggleSubSequence.wiggleMaxLength(seq));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[] {1}, 1},
                {new int[] {2, 2}, 1},
                {new int[] {2, 1}, 2},
                {new int[] {1, 7, 4, 9, 2, 5}, 6},
                {new int[] {1, 17, 5, 10, 13, 15, 10, 5, 16, 8}, 7},
                {new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, 2}
        });
    }
}
