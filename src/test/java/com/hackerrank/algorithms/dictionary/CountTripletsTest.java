package com.hackerrank.algorithms.dictionary;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CountTripletsTest {
  private final TestCase tc;

  public CountTripletsTest(TestCase testCase) {
    this.tc = testCase;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> tcs() {
    return Arrays.asList(
        new Object[][] {
          {tc(2, 4, 1, 4, 16, 64)},
          {tc(2, 2, 1, 2, 2, 4)},
          {tc(6, 3, 1, 3, 9, 9, 27, 81)},
          {tc(3, 2, 1, 2, 1, 2, 4)},
          {tc(161700, 1, IntStream.range(0, 100).map(n -> 1).toArray())}
        });
  }

  private static TestCase tc(long expected, long ratio, int... nums) {
    final List<Long> numbers = Arrays.stream(nums).mapToObj(Long::new).collect(Collectors.toList());
    return new TestCase(expected, ratio, numbers);
  }

  @Test
  public void testCountTriplets() {
    assertEquals(tc.expected, CountTriplets.countTriplets(tc.numbers, tc.ratio));
  }

  private static class TestCase {
    private final long expected;
    private final long ratio;
    private final List<Long> numbers;

    private TestCase(long expected, long ratio, List<Long> numbers) {
      this.expected = expected;
      this.ratio = ratio;
      this.numbers = numbers;
    }
  }
}
