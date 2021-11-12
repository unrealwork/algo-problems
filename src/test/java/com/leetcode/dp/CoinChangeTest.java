package com.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoinChangeTest {

    @Test
    public void coinChange() {
        Assert.assertEquals(3, CoinChange.coinChange(new int[]{1, 2, 5}, 11));
    }
}
