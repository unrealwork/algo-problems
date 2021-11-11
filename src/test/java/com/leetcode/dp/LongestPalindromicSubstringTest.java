package com.leetcode.dp;

import junit.framework.Assert;
import org.junit.Test;

public class LongestPalindromicSubstringTest {

    @Test
    public void testLongestPalindrome() {
        Assert.assertEquals("bab", LongestPalindromicSubstring.longestPalindrome("babad"));
    }

    @Test
    public void testLongestPalindrome1() {
        Assert.assertEquals("bb", LongestPalindromicSubstring.longestPalindrome("cbbd"));
    }

    @Test
    public void testLongestPalindrome2() {
        Assert.assertEquals("a", LongestPalindromicSubstring.longestPalindrome("a"));
    }

    @Test
    public void testLongestPalindrome3() {
        Assert.assertEquals("a", LongestPalindromicSubstring.longestPalindrome("ac"));
    }

    @Test
    public void testLongestPalindrome4() {
        Assert.assertEquals("ccc", LongestPalindromicSubstring.longestPalindrome("ccc"));
    }

    @Test
    public void testLongestPalindrome5() {
        Assert.assertEquals("cccc", LongestPalindromicSubstring.longestPalindrome("cccc"));
    }

    @Test
    public void testLongestPalindrome6() {
        Assert.assertEquals("aca", LongestPalindromicSubstring.longestPalindrome("aacabdkacaa"));
    }

    @Test
    public void testLongestPalindrome7() {
        Assert.assertEquals("bacab", LongestPalindromicSubstring.longestPalindrome("bacabab"));
    }

    @Test
    public void testLongestPalindrome8() {
        Assert.assertEquals("anana", LongestPalindromicSubstring.longestPalindrome("bananas"));
    }

    @Test
    public void testLongestPalindrome9() {
        Assert.assertEquals("ababababababa", LongestPalindromicSubstring.longestPalindrome("ababababababa"));
    }
}
