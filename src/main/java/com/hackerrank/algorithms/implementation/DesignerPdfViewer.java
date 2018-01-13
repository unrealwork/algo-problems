package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

public class DesignerPdfViewer {

  static int designerPdfViewer(int[] h, String word) {
    // Complete this function
    return word.chars().map(c -> h[c - 'a']).max().getAsInt() * word.length();
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int[] h = new int[26];
    for (int h_i = 0; h_i < 26; h_i++) {
      h[h_i] = in.nextInt();
    }
    String word = in.next();
    int result = designerPdfViewer(h, word);
    System.out.println(result);
    in.close();
  }
}
