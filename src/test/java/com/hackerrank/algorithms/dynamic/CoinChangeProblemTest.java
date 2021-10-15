package com.hackerrank.algorithms.dynamic;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;

@RunWith(Parameterized.class)
public class CoinChangeProblemTest {
    public final TestCase testCase;

    public CoinChangeProblemTest(TestCase testCase) {
        this.testCase = testCase;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testCases() {
        return asList(new Object[][]{
                {TestCase.testCase(
                        4, 4, 1, 2, 3)},

                {TestCase.testCase(
                        5, 10, 2, 5, 3, 6)}
        });
    }

    @Test
    public void testGetWays1() {
        final long actual = CoinChangeProblem.getWays(testCase.n, testCase.coins);
        Assert.assertEquals(testCase.expected, actual);
    }

    private static class TestCase {
        private final List<Long> coins;
        private final long expected;
        private final int n;

        private TestCase(long expected, int n, List<Long> coins) {
            this.n = n;
            this.coins = coins;
            this.expected = expected;
        }

        private static TestCase testCase(long expected, int n, int... coins) {
            List<Long> list = new ArrayList<>(coins.length);
            for (int coin : coins) {
                list.add((long) coin);
            }
            return new TestCase(expected, n, list);
        }
    }
}
