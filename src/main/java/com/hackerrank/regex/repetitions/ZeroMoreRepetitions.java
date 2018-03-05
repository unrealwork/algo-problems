package com.hackerrank.regex.repetitions;

import com.hackerrank.regex.Regex_Test;

public class ZeroMoreRepetitions {

  public static void main(String[] args) {
    Regex_Test tester = new Regex_Test();
    tester.checker("^\\d{2,}[a-z]*[A-Z]*$");
  }
}
