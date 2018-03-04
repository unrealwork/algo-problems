package com.hackerrank.regex.repetitions;

import com.hackerrank.regex.Regex_Test;

public class XRepetitions {

  public static void main(String[] args) {
    Regex_Test tester = new Regex_Test();
    tester.checker("^[a-zA-Z02468]{40}[13579\\s]{5}$");
  }
}
