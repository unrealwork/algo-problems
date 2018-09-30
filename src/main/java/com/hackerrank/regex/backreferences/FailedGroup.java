package com.hackerrank.regex.backreferences;

import com.hackerrank.regex.Regex_Test;

public class FailedGroup {

    public static void main(String[] args) {
        Regex_Test tester = new Regex_Test();
        tester.checker("^\\d\\d(-?)?(\\d\\d\\1){2}\\d\\d$"); // Use \\ instead of using \
    }
}
