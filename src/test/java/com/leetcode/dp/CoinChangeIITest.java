package com.leetcode.dp;

import junit.framework.Assert;
import org.testng.annotations.Test;

@Test
public class CoinChangeIITest {

    public void testCoinChange() {
        Assert.assertEquals(4, CoinChangeII.change(5, new int[]{1, 2, 5}));
    }
}
