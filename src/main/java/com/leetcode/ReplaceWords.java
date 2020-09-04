package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReplaceWords {
    public static String replaceWords(List<String> dictionary, String sentence) {
        List<String> sortedDictionary = dictionary.stream()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
        final String[] words = sentence.split("\\s+");
        return Arrays.stream(words)
                .map(word -> root(word, sortedDictionary))
                .collect(Collectors.joining(" "));

    }

    private static String root(final String word, List<String> sortedRoots) {
        return sortedRoots.stream().filter(word::startsWith)
                .findFirst().orElse(word);
    }
}
