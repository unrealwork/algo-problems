package com.leetcode.slidingwindow;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.testng.Assert;

import java.util.Arrays;
import java.util.Collection;

import static com.leetcode.slidingwindow.LongestSubstringWithAtLeastKDistinctChars.longestSubstring;

@RunWith(Parameterized.class)
public class LongestSubstringWithAtLeastKDistinctCharsTest {
    private final String nums;
    private final int k;
    private final int expected;

    public LongestSubstringWithAtLeastKDistinctCharsTest(String s, int k, int expected) {
        this.nums = s;
        this.k = k;
        this.expected = expected;
    }

    @Test
    public void testLongestSubstring() {
        Assert.assertEquals(expected, longestSubstring(nums, k));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"aaabb", 3, 3},
                {"ababbc", 2, 5},
                {"aabbccccddda", 3, 7},
                {"bbaaacbd", 3, 3},
                {"bbaaabbd", 3, 7}
        });
    }
}
