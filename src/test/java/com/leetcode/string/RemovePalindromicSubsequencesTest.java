package com.leetcode.string;

import org.junit.Test;

import static com.leetcode.string.RemovePalindromicSubsequences.removePalindromeSub;
import static org.junit.Assert.*;

public class RemovePalindromicSubsequencesTest {

    @Test
    public void testRemovePalindromeSub() {
        assertEquals(1, removePalindromeSub("ababa"));
    }
    
    @Test
    public void testRemovePalindromeSub2() {
        assertEquals(2, removePalindromeSub("ababab"));
    }
    
    @Test
    public void testRemovePalindromeSub3() {
        assertEquals(2, removePalindromeSub("abb"));
    }
    
    @Test
    public void testRemovePalindromeSub4() {
        assertEquals(2, removePalindromeSub("baabb"));
    }
    
    @Test
    public void testRemovePalindromeSub5() {
        assertEquals(1, removePalindromeSub("aabbaa"));
    }
}
