package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

public class ViralAdvertising {

  static int viralAdvertising(int n) {
    // Complete this function
    int sum = 0;
    int recipients = 5;
    for (int i = 0; i < n; i++) {
      int nextRecipients = recipients / 2;
      sum += nextRecipients;
      recipients = nextRecipients * 3;
    }
    return sum;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int result = viralAdvertising(n);
    System.out.println(result);
    in.close();
  }
}
