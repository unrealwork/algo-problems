package com.leetcode.math;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DivideTwoIntegersTest {

    @Test
    public void testDivide1() {
        Assert.assertEquals(0, DivideTwoIntegers.divide(0, 10));
    }

    @Test
    public void testDivide2() {
        Assert.assertEquals(6, DivideTwoIntegers.divide(13, 2));
    }

    @Test
    public void testDivide3() {
        Assert.assertEquals(-6, DivideTwoIntegers.divide(-13, 2));
    }

    @Test
    public void testDivide4() {
        Assert.assertEquals(3, DivideTwoIntegers.divide(10, 3));
    }

    @Test
    public void testDivide5() {
        Assert.assertEquals(-2, DivideTwoIntegers.divide(7, -3));
    }

    @Test
    public void testDivide6() {
        Assert.assertEquals(Integer.MIN_VALUE, DivideTwoIntegers.divide(Integer.MIN_VALUE, 1));
    }

    @Test
    public void testDivide7() {
        Assert.assertEquals(1, DivideTwoIntegers.divide(1, 1));
    }

    @Test
    public void testDivide8() {
        Assert.assertEquals(2147483647, DivideTwoIntegers.divide(2147483647, 1));
    }

    @Test
    public void testDivide9() {
        Assert.assertEquals((1 << 30) - 1, DivideTwoIntegers.divide(2147483647, 2));
    }

    @Test
    public void testDivide10() {
        Assert.assertEquals(-(1 << 30), DivideTwoIntegers.divide(Integer.MIN_VALUE, 2));
    }

    @Test
    public void testDivide11() {
        Assert.assertEquals(0, DivideTwoIntegers.divide(
                -1010369383, Integer.MIN_VALUE));
    }

    @Test
    public void testDivide12() {
        Assert.assertEquals(-1, DivideTwoIntegers.divide(1100540749,
                -1090366779));
    }

}
