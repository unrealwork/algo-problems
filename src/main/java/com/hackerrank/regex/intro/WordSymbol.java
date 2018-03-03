package com.hackerrank.regex.intro;

import com.hackerrank.regex.Regex_Test;

public class WordSymbol {

  public static void main(String[] args) {
    Regex_Test tester = new Regex_Test();
    tester.checker("\\w{3}\\W\\w{10}\\W\\w{3}");
  }
}
