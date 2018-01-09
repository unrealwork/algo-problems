package com.hackerrank.algorithms.greedy;

import java.util.Scanner;

public class BeutifulString {

  static int beautifulBinaryString(String b) {
    // Complete this function
    char[] ignored = "010".toCharArray();
    int index = 0;
    int res = 0;
    char[] bArr = b.toCharArray();
    for (int i = 0; i < bArr.length - 1; i++) {
      char c = bArr[i];
      if (c == ignored[index] && ignored[index + 1] == bArr[i + 1]) {
        index++;
      } else {
        index = 0;
      }
      if (index == 2) {
        res++;
        bArr[i + 1] = '1';
        index = 0;
      }
    }
    String rB = new String(bArr);
    return res;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    String b = in.next();
    int result = beautifulBinaryString(b);
    System.out.println(result);
    in.close();
  }
}
