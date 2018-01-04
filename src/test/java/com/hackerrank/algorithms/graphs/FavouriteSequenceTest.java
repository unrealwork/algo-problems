package com.hackerrank.algorithms.graphs;

import static com.hackerrank.SolutionIO.io;

import com.hackerrank.Solution;
import com.hackerrank.SolutionIO;
import com.hackerrank.algorithms.SolutionTest;
import java.util.Arrays;
import java.util.List;

public class FavouriteSequenceTest extends SolutionTest {


  @Override
  public Solution solver() {
    return new FavouriteSequence();
  }

  @Override
  public List<SolutionIO> testCases() {
    return Arrays.asList(
        io("fav-seq/1.in", "fav-seq/1.out"),
        io("fav-seq/7.in", "fav-seq/7.out")
    );
  }
}