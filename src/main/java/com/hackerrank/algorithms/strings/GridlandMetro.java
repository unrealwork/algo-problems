package com.hackerrank.algorithms.strings;

import java.util.Arrays;
import java.util.Scanner;

public class GridlandMetro {

  static long gridlandMetro(long n, long m, long k, int[][] track) {
    // Complete this function
    if (k == 0) {
      return n * m;
    }
    long res = 0;
    Arrays.sort(track, (t1, t2) -> {
      int compareRes = Integer.compare(t1[0], t2[0]);
      if (compareRes != 0) {
        return compareRes;
      } else {
        compareRes = Integer.compare(t1[1], t2[1]);
        if (compareRes != 0) {
          return compareRes;
        } else {
          return Integer.compare(t1[2], t2[2]);
        }
      }
    });
    int lastCovered = 0;
    long rowFilled = 0;
    int lastIndex = 0;
    for (int i = 0; i < track.length; i++) {
      int[] t = track[i];
      if (t[0] != track[lastIndex][0]) {
        lastIndex = i;
        res += rowFilled;
        rowFilled = 0;
        lastCovered = 0;
      }
      if (lastCovered < t[1]) {
        rowFilled += (t[2] - t[1] + 1);
        lastCovered = t[2];
      } else {
        if (lastCovered < t[2]) {
          rowFilled += (t[2] - lastCovered);
          lastCovered = t[2];
        }
      }
    }
    return n * m - rowFilled - res;
  }

  public static int filledCell(boolean[] row) {
    int res = 0;
    for (boolean r : row) {
      if (r) {
        res++;
      }
    }
    return res;
  }

  private static long countRow(int m, int k, int[][] track, int r) {
    long res = 0;
    boolean[] row = new boolean[m];
    for (int j = 0; j < k; j++) {
      if (j == r) {
        for (int i = track[r][1]; i < track[r][2]; i++) {
          row[i] = true;
        }
      }
    }
    for (int i = 0; i < m; i++) {
      if (!row[i]) {
        res++;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    int k = in.nextInt();
    int[][] track = new int[k][3];
    for (int track_i = 0; track_i < k; track_i++) {
      for (int track_j = 0; track_j < 3; track_j++) {
        track[track_i][track_j] = in.nextInt();
      }
    }
    long result = gridlandMetro(n, m, k, track);
    System.out.println(result);
    in.close();
  }
}
