package com.hackerrank.algorithms.recursion;

import com.hackerrank.Solution;
import com.hackerrank.SolutionIO;
import com.hackerrank.algorithms.SolutionTest;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CrosswordPuzzleTest extends SolutionTest {

  @Override
  public Optional<String> casesDirectory() {
    return Optional.of("crossword");
  }

  @Override
  public Solution solver() {
    return new CrosswordPuzzle();
  }

  @Override
  public List<SolutionIO> testCases() {
    return Arrays.asList(
        SolutionIO.io("0.in", "0.out"),
        SolutionIO.io("1.in", "1.out")
    );
  }
}