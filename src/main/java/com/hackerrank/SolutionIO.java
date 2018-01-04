package com.hackerrank;

public class SolutionIO {

  private final String inputFileName;
  private final String outputFileName;

  public static SolutionIO io(String i, String o) {
    return new SolutionIO(i, o);
  }

  private SolutionIO(String inputFileName, String outputFileName) {
    this.inputFileName = inputFileName;
    this.outputFileName = outputFileName;
  }

  public String getInputFileName() {
    return inputFileName;
  }

  public String getOutputFileName() {
    return outputFileName;
  }

  public String[] fields() {
    return new String[]{inputFileName, outputFileName};
  }
}
