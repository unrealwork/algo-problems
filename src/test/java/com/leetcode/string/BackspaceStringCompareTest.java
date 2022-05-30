package com.leetcode.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class BackspaceStringCompareTest {

    @Test
    public void testBackspaceCompare() {
        assertTrue(BackspaceStringCompare.backspaceCompare("ab##", "c#d#"));
        assertTrue(BackspaceStringCompare.backspaceCompare("ab#c", "ad#c"));
    }
}
