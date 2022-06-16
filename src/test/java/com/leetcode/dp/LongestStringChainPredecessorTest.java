package com.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static com.leetcode.dp.LongestStringChain.isPredecessor;

@RunWith(Parameterized.class)
public class LongestStringChainPredecessorTest {
    private final String s;
    private final String t;
    private final boolean expected;

    public LongestStringChainPredecessorTest(String s, String t, boolean expected) {
        this.s = s;
        this.t = t;
        this.expected = expected;
    }

    @Test
    public void testIsPredecessor() {
        Assert.assertEquals(expected, isPredecessor(s, t));
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"cab", "ab", true},
                {"ba", "a", true},
                {"ba", "b", true},
                {"bda", "ba", true},
                {"bdca", "bda", true},
                {"bbba", "bda", false},
        });
    }

}
