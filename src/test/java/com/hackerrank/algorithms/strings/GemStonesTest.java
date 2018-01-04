package com.hackerrank.algorithms.strings;

import static com.hackerrank.SolutionIO.io;

import com.hackerrank.SolutionIO;
import com.hackerrank.algorithms.SolutionTest;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class GemStonesTest extends SolutionTest {

  @Override
  public Optional<String> casesDirectory() {
    return Optional.of("gem-stone");
  }

  @Override
  public GemStones solver() {
    return new GemStones();
  }

  @Override
  public List<SolutionIO> testCases() {
    return Arrays.asList(
        io("0.in", "0.out")
    );
  }
}