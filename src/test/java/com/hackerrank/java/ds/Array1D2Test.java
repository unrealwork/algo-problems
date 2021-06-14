package com.hackerrank.java.ds;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Array1D2Test {

    @Test
    public void canWin() {
        Assert.assertTrue(Array1D2.canWin(4, new int[]{0, 1, 1, 0, 0, 1, 1, 0, 1}));
    }
}