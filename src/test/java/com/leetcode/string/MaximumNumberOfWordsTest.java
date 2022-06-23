package com.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumNumberOfWordsTest {

    @Test
    public void testNumberOfWords() {
        Assert.assertEquals(4, MaximumNumberOfWords.numberOfWords("i think so too"));
    }
}
