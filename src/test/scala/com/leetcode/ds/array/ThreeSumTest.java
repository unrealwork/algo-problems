package com.leetcode.ds.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThreeSumTest {

  @Test
  public void testThreeSum() {
    List<List<Integer>> actual = ThreeSum.threeSum(new int[] {-1, 0, 1, 2, -1, -4});
    final List<List<Integer>> expected = intListOfList(new int[][] {{-1, -1, 2}, {-1, 0, 1}});
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testThreeSum1() {
    List<List<Integer>> actual = ThreeSum.threeSum(new int[] {});
    final List<List<Integer>> expected = Collections.emptyList();
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testThreeSum2() {
    List<List<Integer>> actual = ThreeSum.threeSum(new int[] {});
    final List<List<Integer>> expected = Collections.emptyList();
    Assert.assertEquals(expected, actual);
  }

  private List<List<Integer>> intListOfList(int[][] nums) {
    return Arrays.stream(nums)
        .map(ints -> IntStream.of(ints).boxed().collect(Collectors.toList()))
        .collect(Collectors.toList());
  }
}
