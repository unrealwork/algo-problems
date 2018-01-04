package com.hackerrank.algorithms.graphs;

import static com.hackerrank.SolutionIO.io;

import com.hackerrank.SolutionIO;
import com.hackerrank.algorithms.AbstractTest;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class FavouriteSequenceTest extends AbstractTest {

  @Override
  public OutputStream solve(InputStream is, PrintStream os) {
    return new FavouriteSequence().solve(is, os);
  }

  @Override
  public List<SolutionIO> testCases() {
    return Arrays.asList(
        io("fav-seq/1.in", "fav-seq/1.out"),
        io("fav-seq/7.in", "fav-seq/7.out")
    );
  }
}