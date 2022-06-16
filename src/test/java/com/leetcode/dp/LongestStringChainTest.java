package com.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static com.leetcode.dp.LongestStringChain.longestStrChain;

@RunWith(Parameterized.class)
public class LongestStringChainTest {
    private final String[] words;
    private final int expected;

    public LongestStringChainTest(String[] words, int expected) {
        this.words = words;
        this.expected = expected;
    }

    @Test
    public void testLongestStrChain() {
        Assert.assertEquals(expected, longestStrChain(words));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new String[] {"a"}, 1},
                {new String[] {"aa"}, 1},
                {new String[] {"a", "b", "bca", "bda", "ba", "bdca"}, 4},
                {new String[] {"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"}, 5},
                {new String[] {"abcd", "dbqca"}, 1},
                {new String[] {"bdca", "bda", "ca", "dca", "a"}, 4},
                {new String[] {"a", "ab", "ac", "bd", "abc", "abd", "abdd"}, 4}
        });
    }
}
