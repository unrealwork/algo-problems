package com.leetcode.string;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class NumberValidWordsTest {
    private final String s;
    private final int expected;

    public NumberValidWordsTest(String s, int expected) {
        this.s = s;
        this.expected = expected;
    }

    @Test
    public void testCountValidWords() {
        Assert.assertEquals(expected, NumberValidWords.countValidWords(s));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"cat and  dog", 3},
                {"!this  1-s b8d!", 0},
                {"alice and  bob are playing stone-game10", 5},
                {"a", 1},
                {"a-b", 1},
                {"-ab", 0},
                {"ab-", 0},
                {"ab,", 1},
                {"a!b", 0},
                {"a!,", 0},
                {"q-,", 0},
                {". ! 7hk  al6 l! aon49esj35la k3 7u2tkh  7i9y5  !jyylhppd et v- h!ogsouv 5", 4}

        });
    }
}
