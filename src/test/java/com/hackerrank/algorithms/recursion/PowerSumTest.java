package com.hackerrank.algorithms.recursion;

import static com.hackerrank.SolutionIO.io;

import com.hackerrank.Solution;
import com.hackerrank.SolutionIO;
import com.hackerrank.algorithms.SolutionTest;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PowerSumTest extends SolutionTest {

  @Override
  public Optional<String> casesDirectory() {
    return Optional.of("power-sum");
  }

  @Override
  public Solution solver() {
    return new PowerSum();
  }

  @Override
  public List<SolutionIO> testCases() {
    return Arrays.asList(
        io("0.in", "0.out"),
        io("1.in", "1.out")
    );
  }
}