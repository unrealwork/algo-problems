package com.hackerrank.algorithms.strings;

import com.hackerrank.Solution;
import com.hackerrank.SolutionIO;
import com.hackerrank.algorithms.SolutionTest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WeightedUniformStringTest extends SolutionTest {

  @Override
  public Optional<String> casesDirectory() {
    return Optional.of("weighted-uniform-strings");
  }

  @Override
  public Solution solver() {
    return new WeightedUniformString();
  }

  @Override
  public List<SolutionIO> testCases() {
    return Arrays.asList(
        SolutionIO.io("0.in", "0.out"),
        SolutionIO.io("2.in", "2.out")
    );
  }

  @Test(dataProvider = "provideDictCreation")
  public void testCreateDict(String s, int[][] pairs) {
    Assert.assertEquals(WeightedUniformString.createDict(s), map(pairs));
  }

  public Map<Integer, Long> map(int[][] pairs) {
    Map<Integer, Long> expectedResult = new HashMap<>();
    for (int[] pair : pairs) {
      expectedResult.put(pair[0], (long) pair[1]);
    }
    return expectedResult;
  }

  @DataProvider
  private Object[][] provideDictCreation() {
    return new Object[][]{
        {"abccddde",
            new int[][]{
                {1, 1}, {2, 1}, {3, 2}, {4, 3}, {5, 1}
            }}
    };
  }
}