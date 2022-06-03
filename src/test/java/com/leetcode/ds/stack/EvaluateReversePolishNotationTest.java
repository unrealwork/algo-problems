package com.leetcode.ds.stack;

import org.junit.Assert;
import org.junit.Test;

public class EvaluateReversePolishNotationTest {

    @Test
    public void evalRPN() {
        Assert.assertEquals(6, EvaluateReversePolishNotation.evalRPN(new String[] {"4", "13", "5", "/", "+"}));
    }
}
