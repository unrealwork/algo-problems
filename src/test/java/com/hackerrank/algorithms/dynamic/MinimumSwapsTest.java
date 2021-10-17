package com.hackerrank.algorithms.dynamic;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;

import static com.hackerrank.algorithms.dynamic.MinimumSwapsTest.TestCase.testCase;
import static java.util.Arrays.asList;

@RunWith(Parameterized.class)
public class MinimumSwapsTest {
    private final TestCase testCase;

    public MinimumSwapsTest(TestCase testCase) {
        this.testCase = testCase;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testCases() {
        return asList(new Object[][]{
                {testCase(3,
                        4, 3, 1, 2)},
                {testCase(3,
                        2, 3, 4, 1, 5)
                },
                {testCase(3,
                        1, 3, 5, 2, 4, 6, 7)}
        });
    }

    @Test
    public void minimumSwaps() {
        Assert.assertEquals(testCase.expected, MinimumSwaps.minimumSwaps(testCase.arr));
    }

    static class TestCase {
        private final int expected;
        private final int[] arr;

        private TestCase(int expected, int[] arr) {
            this.expected = expected;
            this.arr = arr;
        }

        static TestCase testCase(int expected, int... arr) {
            return new TestCase(expected, arr);
        }
    }
}
