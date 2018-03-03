package com.hackerrank.regex.intro;

import com.hackerrank.regex.Regex_Test;

public class Whitespace {

  public static void main(String[] args) {
    Regex_Test tester = new Regex_Test();
    tester.checker("(\\S{2}\\s){2}\\S{2}");
  }
}
