package com.hackerrank.java.strings;

import java.util.Scanner;

public class Anagrams {
    static boolean isAnagram(String a, String b) {
        // Complete the function
        if (a.length() != b.length()) {
            return false;
        }
        final int[] dict = new int['z' - 'a' + 1];
        a.chars().forEach(symbol -> dict[Character.toLowerCase(symbol) - 'a']++);
        for (int i = 0; i < b.length(); i++) {
            int index = Character.toLowerCase(b.charAt(i)) - 'a';
            if (dict[index] == 0) {
                return false;
            }
            dict[index]--;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }
}
