package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

public class MagicSquare {

  private static int[][] IDEAL = {
      {4, 9, 2},
      {3, 5, 7},
      {8, 1, 6}
  };

  static int formingMagicSquare(int[][] s) {
    // Complete this function
    int[][] magic = IDEAL;
    int min = getAbsoluteMin(magic, s);
    for (int k = 0; k < 3; k++) {
      magic = rotateRight(magic);
      int absoluteMin = getAbsoluteMin(magic, s);
      if (absoluteMin < min) {
        min = absoluteMin;
      }
    }
    return min;
  }

  private static int getAbsoluteMin(int[][] magic, int[][] s) {
    int min = getLocalMin(s, magic);
    int localMin = getLocalMin(mirrorDiagonal(magic), s);
    if (localMin < min) {
      min = localMin;
    }
    localMin = getLocalMin(mirrorAntiDiagonal(magic), s);
    if (localMin < min) {
      min = localMin;
    }
    localMin = getLocalMin(flipHorizontally(magic), s);
    if (localMin < min) {
      min = localMin;
    }
    localMin = getLocalMin(flipVertically(magic), s);
    if (localMin < min) {
      min = localMin;
    }
    return min;
  }

  public static int[][] flipHorizontally(int[][] in) {
    int[][] out = new int[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        out[i][3 - j - 1] = in[i][j];
      }
    }
    return out;
  }


  private static int getLocalMin(int[][] s, int[][] magic) {
    int localMin = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        localMin += Math.abs(s[i][j] - magic[i][j]);
      }
    }
    return localMin;
  }


  static int[][] rotateRight(int[][] matrix) {
    int[][] ret = new int[3][3];
    int n = 3;
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        ret[i][j] = matrix[n - j - 1][i];
      }
    }

    return ret;
  }

  static int[][] flipVertically(int[][] gridToFlip) {
    int[][] gridToReturn = new int[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        gridToReturn[2 - i][j] = gridToFlip[i][j];
      }
    }
    return gridToReturn;
  }

  private static int[][] mirrorDiagonal(int[][] matrix) {
    int[][] ret = new int[3][3];
    int n = 3;
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        ret[i][j] = matrix[j][i];
      }
    }
    return ret;
  }

  private static int[][] mirrorAntiDiagonal(int[][] matrix) {
    int[][] ret = new int[3][3];
    int n = 3;
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        ret[i][j] = matrix[2 - j][2 - i];
      }
    }
    return ret;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int[][] s = new int[3][3];
    for (int s_i = 0; s_i < 3; s_i++) {
      for (int s_j = 0; s_j < 3; s_j++) {
        s[s_i][s_j] = in.nextInt();
      }
    }
    int result = formingMagicSquare(s);
    System.out.println(result);
    in.close();
  }

}
