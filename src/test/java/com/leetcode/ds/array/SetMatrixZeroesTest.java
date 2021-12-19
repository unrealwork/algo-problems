package com.leetcode.ds.array;

import org.junit.Assert;
import org.junit.Test;

public class SetMatrixZeroesTest {

  @Test
  public void testSetZeroes() {
    int[][] matrixBefore = new int[][] {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
    SetMatrixZeroes.setZeroes(matrixBefore);
    Assert.assertArrayEquals(new int[][] {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}}, matrixBefore);
  }
}
