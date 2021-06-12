package com.hackerrank.java.strings;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StringTokens {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        boolean isToken = false;
        final StringBuilder tokenBuillder = new StringBuilder();
        final List<String> tokens = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!isToken && Character.isAlphabetic(c)) {
                isToken = true;
                tokenBuillder.append(c);
                continue;
            } else {
                if (!Character.isAlphabetic(c)) {
                    if (tokenBuillder.length() > 0) {
                        tokens.add(tokenBuillder.toString());
                        tokenBuillder.setLength(0);
                    }
                    isToken = false;
                } else {
                    tokenBuillder.append(c);
                }
            }
        }
        if (tokenBuillder.length() > 0) {
            tokens.add(tokenBuillder.toString());
        }
        System.out.println(tokens.size());
        tokens.forEach(System.out::println);
        scan.close();
    }
}
