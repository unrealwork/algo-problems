package com.hackerrank.regex.applications;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UKAndUS {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    final String text = IntStream.range(0, n).mapToObj(i -> sc.nextLine())
        .collect(Collectors.joining("\n"));
    int t = sc.nextInt();
    sc.nextLine();
    IntStream.range(0, t).mapToObj(i -> sc.nextLine())
        .map(s ->
            String.format("\\b(%s|%s)\\b",
                s.replaceAll("our", "or"), s))
        .mapToInt(s -> {
          Pattern p = Pattern.compile(s);
          Matcher matcher = p.matcher(text);
          int count = 0;
          while (matcher.find()) {
            count++;
          }
          return count;
        }).forEach(System.out::println);
  }
}
