package com.leetcode.bits;

import org.junit.Test;

import static org.junit.Assert.*;

public class AllBinaryCodesTest {

    @Test
    public void testHasAllCodes() {
        assertTrue(AllBinaryCodes.hasAllCodes("00110110", 2));
    }
    
    @Test
    public void testHasAllCodes1() {
        assertTrue(AllBinaryCodes.hasAllCodes("0110", 1));
    }
    
    @Test
    public void testHasAllCodes2() {
        assertFalse(AllBinaryCodes.hasAllCodes("0110", 2));
    }
    
    @Test
    public void testHasAllCodes3() {
        assertTrue(AllBinaryCodes.hasAllCodes("00000000001011100", 3));
    }
    
    
}
