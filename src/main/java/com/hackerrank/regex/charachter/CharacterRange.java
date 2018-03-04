package com.hackerrank.regex.charachter;

import com.hackerrank.regex.charachter.SpecificCharacters.Regex_Test;

public class CharacterRange {

  public static void main(String[] args) {
    Regex_Test tester = new Regex_Test();
    tester.checker("^[a-z][1-9][^a-z][^A-Z][A-Z]"); // Use \\ instead of using \
  }
}
