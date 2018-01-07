package com.hackerrank.contest.euler;

import static com.hackerrank.SolutionIO.io;

import com.hackerrank.Solution;
import com.hackerrank.SolutionIO;
import com.hackerrank.algorithms.SolutionTest;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UniqueSumSubsetTest extends SolutionTest {

  @Override
  public Optional<String> casesDirectory() {
    return Optional.of("unique-sum-subset");
  }

  @Override
  public Solution solver() {
    return new UniqueSumSubset();
  }

  @Override
  public List<SolutionIO> testCases() {
    return Arrays.asList(
//        io("0.in", "0.out"),
//        io("1.in", "1.out"),
//        io("1.in", "1.out"),
        io("3.in", "3.out")
    );
  }
}