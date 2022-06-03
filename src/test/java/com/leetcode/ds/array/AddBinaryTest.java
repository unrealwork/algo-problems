package com.leetcode.ds.array;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddBinaryTest {

    @Test
    public void testAddBinary() {
        Assert.assertEquals("100", AddBinary.addBinary("11", "1"));
    }
    @Test
    public void testAddBinary1() {
        Assert.assertEquals("10101", AddBinary.addBinary("1011", "1010"));
    }
}
