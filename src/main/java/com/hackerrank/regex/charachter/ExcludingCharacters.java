package com.hackerrank.regex.charachter;

import com.hackerrank.regex.charachter.SpecificCharacters.Regex_Test;

public class ExcludingCharacters {

  public static void main(String[] args) {
    Regex_Test tester = new Regex_Test();
    tester.checker("^\\D[^aoiue][^bcDF]\\S[^AEOUI][^.,]$");
  }
}
