package com.hackerrank.algorithms;

import static com.hackerrank.SolutionIO.io;

import com.hackerrank.SolutionIO;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.StreamUtils;

public abstract class AbstractTest {

  public Optional<String> casesDirectory() {
    return Optional.empty();
  }

  public abstract OutputStream solve(InputStream is, PrintStream os);

  public abstract List<SolutionIO> testCases();

  @Test(dataProvider = "solutionProvider")
  public void testSolution(String inputFileName,
      String expectedResultFileName) {
    Class<?> clazz = this.getClass();
    InputStream is = clazz.getResourceAsStream(inputFileName);
    String result;
    String expectedResult;
    try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
      solve(is, new PrintStream(os));
      result = os.toString(StandardCharsets.UTF_8.name());
      expectedResult = StreamUtils.toString(clazz
          .getResourceAsStream(expectedResultFileName));
      Assert.assertEquals(result, expectedResult);
    } catch (IOException e) {
      throw new IllegalStateException();
    }
  }


  @DataProvider
  public Object[][] solutionProvider() {
    return testCases().stream().map(solutionIO -> io(
        casesPath(solutionIO.getInputFileName()),
        casesPath(solutionIO.getOutputFileName())))
        .map(SolutionIO::fields)
        .toArray(Object[][]::new);
  }

  private String casesPath(String inputFileName) {
    Optional<String> s = casesDirectory();
    String prefix = s.map(s1 -> (s1 + File.separator)).orElse("");
    return prefix + inputFileName;
  }
}
