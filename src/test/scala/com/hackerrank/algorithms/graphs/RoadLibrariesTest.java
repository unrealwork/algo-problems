package com.hackerrank.algorithms.graphs;

import static com.hackerrank.algorithms.graphs.RoadLibraries.solve;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.utils.StreamUtils;

public class RoadLibrariesTest {


  @Test(dataProvider = "provideRoadLibrariesData")
  public void testRoadsAndLibraries(String inputFileName,
      String expectedResultFileName) {
    Class<? extends RoadLibrariesTest> clazz = this.getClass();
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
  private Object[][] provideRoadLibrariesData() {
    return new Object[][]{
        {
            "rl_input1.txt",
            "rl_output1.txt"
        },
        {
            "rl_input3.txt",
            "rl_output3.txt"
        }
    };
  }
}