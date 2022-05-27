package com.leetcode.bits;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountingBitsTest {

    @Test
    public void countBits() {
        Assert.assertArrayEquals(new int[] {0, 1, 1, 2, 1, 2}, CountingBits.countBits(5));
    }
}
