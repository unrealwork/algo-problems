package com.leetcode.ds.array;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MissingNumberTest {

    @Test
    public void missingNumber() {
        int actual = MissingNumber.missingNumber(new int[] {9, 6, 4, 2, 3, 5, 7, 0, 1});
        Assert.assertEquals(8, actual);
    }
}
