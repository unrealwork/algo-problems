package com.hackerrank.regex.repetitions;

import com.hackerrank.regex.Regex_Test;

public class OneMoreRepetitions {

  public static void main(String[] args) {
    Regex_Test tester = new Regex_Test();
    tester.checker("^\\d+[A-Z]+[a-z]+$");
  }
}
