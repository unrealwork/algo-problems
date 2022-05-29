package com.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

import static com.leetcode.string.MaximumProductWordLengths.maxProduct;
import static org.junit.Assert.*;

public class MaximumProductWordLengthsTest {

    @Test
    public void testMaxProduct() {
        Assert.assertEquals(4, maxProduct(new String[]{"a","ab","abc","d","cd","bcd","abcd"}));
    }
}
