package com.leetcode.string;

import java.util.Arrays;

class GoodString {
    private GoodString() {
        
    }

    public static int minDeletions(String s) {
        int[] frequencies = new int['z' - 'a' + 1];
        int symbolsCount = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (frequencies[index] == 0) {
                symbolsCount++;
            }
            frequencies[index]++;
        }
        int deletionsCount = 0;
        Arrays.sort(frequencies);
        int startIndex = frequencies.length - symbolsCount + 1;
        for (int i = startIndex; i < frequencies.length; i++) {
            if (frequencies[i] == frequencies[i - 1]) {
                int j = i;
                while (frequencies[j] > 0 && frequencies[j] == frequencies[j - 1]) {
                    frequencies[j]--;
                    deletionsCount++;
                    if (frequencies[j] < frequencies[j - 1]) {
                        int tmp = frequencies[j - 1];
                        frequencies[j - 1] = frequencies[j];
                        frequencies[j] = tmp;
                        j--;
                    }
                }
            }
        }
        return deletionsCount;
    }
}
