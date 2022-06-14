package com.leetcode.slidingwindow;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static com.leetcode.slidingwindow.FruitBasket.totalFruit;

@RunWith(Parameterized.class)
public class FruitBasketTest {
    private final int[] fruits;
    private final int expected;

    public FruitBasketTest(int[] fruits, int expected) {
        this.fruits = fruits;
        this.expected = expected;
    }

    @Test
    public void testTotalFruit() {
        Assert.assertEquals(expected, totalFruit(fruits));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]
                {
                        {new int[] {}, 0},
                        {new int[] {2, 1, 2}, 3},
                        {new int[] {1, 2, 3, 2, 2}, 4},
                        {new int[] {0, 1, 2, 2}, 3}
                });
    }
}
