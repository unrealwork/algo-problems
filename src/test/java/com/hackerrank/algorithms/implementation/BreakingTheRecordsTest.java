package com.hackerrank.algorithms.implementation;

import static com.hackerrank.SolutionIO.io;

import com.hackerrank.Solution;
import com.hackerrank.SolutionIO;
import com.hackerrank.algorithms.SolutionTest;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class BreakingTheRecordsTest extends SolutionTest {

  @Override
  public Optional<String> casesDirectory() {
    return Optional.of("breaking-the-records");
  }

  @Override
  public Solution solver() {
    return new BreakingTheRecords();
  }

  @Override
  public List<SolutionIO> testCases() {
    return Arrays.asList(
        io("0.in", "0.out")
    );
  }
}