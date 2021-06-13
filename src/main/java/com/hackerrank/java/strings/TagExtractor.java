package com.hackerrank.java.strings;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagExtractor {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0) {
            String line = in.nextLine();

            //Write your code here
            final Pattern pattern = Pattern.compile("<([^<>]+)>(?<text>[^<>]+)</\\1>");
            String text = line;
            Matcher matcher = pattern.matcher(text);
            if (!matcher.find()) {
                System.out.println("None");
            } else {
                do {
                    final String extractedText = matcher.group("text");
                    System.out.println(extractedText);
                } while (matcher.find());
            }
            testCases--;
        }
    }
}
