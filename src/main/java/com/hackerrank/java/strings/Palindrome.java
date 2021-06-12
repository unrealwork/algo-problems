package com.hackerrank.java.strings;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        /* Enter your code here. Print output to STDOUT. */
        System.out.println(isPalindrome(A) ? "Yes" : "No");
    }

    private static boolean isPalindrome(String s) {
        final int middle = s.length() % 2 == 0 ? s.length() / 2 : s.length() / 2 + 1;
        for (int i = 0; i < middle; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
