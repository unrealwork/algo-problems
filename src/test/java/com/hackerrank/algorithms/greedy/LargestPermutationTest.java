package com.hackerrank.algorithms.greedy;

import com.hackerrank.Solution;
import com.hackerrank.SolutionIO;
import com.hackerrank.algorithms.SolutionTest;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LargestPermutationTest extends SolutionTest {

  @Override
  public Optional<String> casesDirectory() {
    return Optional.of("largest-permutation");
  }

  @Override
  public Solution solver() {
    return new LargestPermutation();
  }

  @Override
  public List<SolutionIO> testCases() {
    return Arrays.asList(
        SolutionIO.io("7.in", "7.out")
    );
  }
}