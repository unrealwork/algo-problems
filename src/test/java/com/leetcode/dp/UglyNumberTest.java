package com.leetcode.dp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.testng.Assert;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class UglyNumberTest {

    private final int num;
    private final boolean expected;

    public UglyNumberTest(int num, boolean expected) {
        this.num = num;
        this.expected = expected;
    }

    @Test
    public void testUgly() {
        boolean res = UglyNumber.ugly(num);
        Assert.assertEquals(expected, res);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {15, true},
                {14, false},
                {13, false},
                {1, true},
                {11, false},
                {4, true},
                {54, true},
                {7, false}
        });
    }
}
