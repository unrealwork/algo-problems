package com.hackerrank.algorithms.greedy;

import com.hackerrank.Solution;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class LargestPermutation implements Solution {

  static int[] largestPermutation(int k, int[] arr) {
    // Complete this function
    int lim = k > arr.length ? arr.length : k;
    int[] indexes = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      indexes[arr[i] - 1] = i;
    }
    int curIndex = 0;
    for (int i = 0; i < lim; i++) {
      while (curIndex < arr.length
          && arr[curIndex] == arr.length - curIndex) {
        curIndex++;
      }
      if (curIndex == arr.length) {
        break;
      }
      int swappedPosition = indexes[arr.length - curIndex - 1];
      int swappedValue = arr[curIndex] - 1;
      swap(arr, indexes[arr.length - curIndex - 1], curIndex);
      indexes[arr.length - curIndex - 1] = curIndex;
      indexes[swappedValue] = swappedPosition;
      curIndex++;
    }
    return arr;
  }


  private static void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  public static void main(String[] args) {
    new LargestPermutation().solve(System.in, System.out);
  }

  @Override
  public OutputStream solve(InputStream is, PrintStream os) {
    Scanner in = new Scanner(is);
    int n = in.nextInt();
    int k = in.nextInt();
    int[] arr = new int[n];
    for (int arr_i = 0; arr_i < n; arr_i++) {
      arr[arr_i] = in.nextInt();
    }
    int[] result = largestPermutation(k, arr);
    for (int i = 0; i < result.length; i++) {
      os.print(result[i] + (i != result.length - 1 ? " " : ""));
    }
    os.println("");

    in.close();
    return os;
  }
}
