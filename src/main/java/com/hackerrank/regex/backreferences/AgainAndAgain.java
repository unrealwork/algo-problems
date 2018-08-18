package com.hackerrank.regex.backreferences;

import com.hackerrank.regex.Regex_Test;

import java.util.regex.Pattern;

public class AgainAndAgain {
    public static void main(String[] args) {
        Pattern result = Pattern.compile("^([a-z])(\\w)(\\s)([^\\w])(\\d)([^\\d])([A-Z])([a-zA-Z])([a,e,i,o,u,A,E,I,O,U])([^\\s])\\1\\2\\3\\4\\5\\6\\7\\8\\9\\10$");
        Regex_Test tester = new Regex_Test();
        tester.checker("ab #1?AZa$ab #1?AZa$˚"); // Use \\ instead of using \

    }
}
