package com.hackerrank.regex.groupingcapturing;

import com.hackerrank.regex.Regex_Test;

public class Alterations {

  public static void main(String[] args) {
    Regex_Test tester = new Regex_Test();
    tester.checker("^(Mr|Mrs|Ms|Dr|Er)[.][a-zA-Z]+$");
  }
}
