package com.leetcode.string;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class FindAllAnagrams {
    private FindAllAnagrams() {
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        if (s.length() < p.length()) {
            return res;
        }
        int[] sWindow = window(s, p);
        int[] pWindow = window(p, p);
        int scanSize = s.length() - p.length() + 1;
        for (int i = 0; i < scanSize; i++) {
            if (Arrays.equals(sWindow, pWindow)) {
                res.add(i);
            }
            if (i < scanSize - 1) {
                sWindow[s.charAt(i)]--;
                sWindow[s.charAt(i + p.length())]++;
            }
        }
        return res;
    }

    private static int[] window(String s, String p) {
        int[] window = new int['z' + 1];
        for (int i = 0; i < p.length(); i++) {
            window[s.charAt(i)]++;
        }
        return window;
    }
}
