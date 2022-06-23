package com.leetcode.string;

class MaximumNumberOfWords {
    private MaximumNumberOfWords() {

    }

    public static int mostWordsFound(String[] sentences) {
        int max = 0;
        for (String sentence : sentences) {
            max = Math.max(numberOfWords(sentence), max);
        }
        return max;
    }

    static int numberOfWords(String s) {
        int count = 0;
        boolean isWord = false;
        for (int i = 0; i < s.length(); i++) {
            if (!isWord && s.charAt(i) != ' ') {
                isWord = true;
                count++;
            } else {
                if (s.charAt(i) == ' ') {
                    isWord = false;
                }
            }
        }
        return count;
    }
}
