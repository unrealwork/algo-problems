package com.hackerrank.algorithms.implementation;

import static com.hackerrank.SolutionIO.io;

import com.hackerrank.SolutionIO;
import com.hackerrank.algorithms.AbstractTest;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class BreakingTheRecordsTest extends AbstractTest {

  @Override
  public String casesDirectory() {
    return "breaking-the-records";
  }

  @Override
  public OutputStream solve(InputStream is, PrintStream os) {
    return new BreakingTheRecords().solve(is, os);
  }

  @Override
  public List<SolutionIO> testCases() {
    return Arrays.asList(
        io("0.in", "0.out")
    );
  }
}