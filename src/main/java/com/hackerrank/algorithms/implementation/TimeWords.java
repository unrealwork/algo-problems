package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

public class TimeWords {

  // TODO: Refactor it to class
  private static String[] NUMBERS = new String[]{
      "zero",
      "one",
      "two",
      "three",
      "four",
      "five",
      "six",
      "seven",
      "eight",
      "nine",
      "ten",
      "eleven",
      "twelve",
      "thirteen",
      "fourteen",
      "fifteen",
      "sixteen",
      "seventeen",
      "eighteen",
      "nineteen",
      "twenty",
      "twenty one",
      "twenty two",
      "twenty three",
      "twenty four",
      "twenty five",
      "twenty six",
      "twenty seven",
      "twenty eight",
      "twenty nine"
  };

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int h = in.nextInt();
    int m = in.nextInt();
    System.out.println(solve(h, m));
    in.close();
  }

  private static String solve(int h, int m) {
    StringBuilder sb = new StringBuilder();
    if (m == 0) {
      sb.append(String.format("%s o' clock", NUMBERS[h]));
    } else {
      if (m < 31) {
        handleMinutes(m, sb, "past", h);
      } else {
        handleMinutes(60 - m, sb, "to", h + 1);
      }
    }
    return sb.toString();
  }

  private static StringBuilder handleMinutes(int m, StringBuilder sb,
      String preposition, int h) {
    if (m == 15) {
      sb.append("quarter ");
    } else if (m == 30) {
      sb.append("half ");
    } else {
      sb.append(String.format("%s minute", NUMBERS[m]));
      if (m % 10 != 1) {
        sb.append("s");
      }
      sb.append(" ");
    }
    sb.append(String.format("%s %s", preposition, NUMBERS[h]));
    return sb;
  }
}
