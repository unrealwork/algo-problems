package com.hackerrank.regex.groupingcapturing;

import com.hackerrank.regex.Regex_Test;

public class WordBoundaries {

  public static void main(String[] args) {
    Regex_Test tester = new Regex_Test();
    tester.checker("\\b[aouieAOUIE][a-zA-Z]*\\b");
  }

}