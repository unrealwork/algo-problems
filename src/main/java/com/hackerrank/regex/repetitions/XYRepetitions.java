package com.hackerrank.regex.repetitions;

import com.hackerrank.regex.Regex_Test;

public class XYRepetitions {

  public static void main(String[] args) {
    Regex_Test tester = new Regex_Test();
    tester.checker("^\\d{1,2}[a-zA-Z]{3,}[.]{0,3}$");
  }
}
