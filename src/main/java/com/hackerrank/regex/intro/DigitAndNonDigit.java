package com.hackerrank.regex.intro;

import com.hackerrank.regex.Regex_Test;

public class DigitAndNonDigit {

  public static void main(String[] args) {
    Regex_Test tester = new Regex_Test();
    tester.checker("\\d{2}\\D\\d{2}\\D\\d{4}");
  }
}
