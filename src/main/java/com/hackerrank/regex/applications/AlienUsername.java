package com.hackerrank.regex.applications;

import java.util.Scanner;
import java.util.stream.IntStream;

public class AlienUsername {

  private static final String ALIEN_PATTERN = "^[._]\\d+[a-zA-Z]*[_]?$";

  public static void main(String[] args) {
    Scanner io = new Scanner(System.in);
    int n = Integer.parseInt(io.nextLine());
    IntStream.range(0, n)
        .mapToObj(i -> io.nextLine().matches(ALIEN_PATTERN))
        .map(b -> b ? "VALID" : "INVALID")
        .forEach(System.out::println);
  }
}
