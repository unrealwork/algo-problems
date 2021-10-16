package com.hackerrank.algorithms.dynamic;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.testng.internal.collections.Ints.asList;

@RunWith(Parameterized.class)
public class KnapsackTest {
    private final TestCase testCase;

    public KnapsackTest(TestCase testCase) {
        this.testCase = testCase;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testCases() {
        return Arrays.asList(new Object[][]{
                {TestCase.testCase(
                        12, 12, 1, 6, 9)},

                {TestCase.testCase(
                        9, 9, 3, 4, 4, 4, 8)}
        });
    }

    @Test
    public void testUnboundedKnapsack() {
        Assert.assertEquals(testCase.expected, Knapsack.unboundedKnapsack(testCase.n, testCase.weights));
    }

    private static class TestCase {
        private final List<Integer> weights;
        private final long expected;
        private final int n;

        private TestCase(long expected, int n, List<Integer> weights) {
            this.n = n;
            this.weights = weights;
            this.expected = expected;
        }

        private static TestCase testCase(long expected, int n, int... coins) {
            List<Integer> list = asList(coins);
            return new TestCase(expected, n, list);
        }
    }
}
