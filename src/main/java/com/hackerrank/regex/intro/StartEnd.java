package com.hackerrank.regex.intro;

import com.hackerrank.regex.Regex_Test;

public class StartEnd {

  public static void main(String[] args) {
    Regex_Test tester = new Regex_Test();
    tester.checker("^\\d\\w{4}[.]$");
  }
}
