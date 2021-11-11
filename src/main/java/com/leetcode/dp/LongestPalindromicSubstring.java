package com.leetcode.dp;

@SuppressWarnings("squid:S3776")
public class LongestPalindromicSubstring {
    private LongestPalindromicSubstring() {
    }

    public static String longestPalindrome(String s) {
        int max = 1;
        int longestPos = 0;
        int repeated = 1;
        boolean[] palindroms = new boolean[s.length() + 1];
        palindroms[1] = true;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                repeated++;
            } else {
                repeated = 1;
            }
            for (int j = i + 1; j > 0; j--) {
                if (palindroms[j]) {
                    palindroms[j] = false;
                    if (i > j && s.charAt(i) == s.charAt(i - 1 - j)) {
                        palindroms[j + 2] = true;
                        if (j + 2 > max) {
                            max = j + 2;
                            longestPos = i;
                        }
                    }
                }

            }
            palindroms[repeated] = true;
            if (repeated > max) {
                max = repeated;
                longestPos = i;
            }
            palindroms[1] = true;

        }
        return s.substring(longestPos - max + 1, longestPos + 1);
    }
}
