package com.hackerrank.algorithms.strings;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Result {

    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
        // Write your code here
        final Map<Character, Long> freqMap = freqMap(s);
        if (freqMap.size() == 1) {
            return "YES";
        } else {
            boolean isValid = true;
            Collection<Long> values = freqMap.values();
            final long minFreq = values.stream().min(Long::compareTo)
                    .orElseThrow(IllegalStateException::new);
            int availableErrors = 1;
            for (Long f : values) {
                if (f != minFreq && f - minFreq > 1) {
                    isValid = false;
                    break;
                }

                if (f != minFreq) {
                    if (f - minFreq == 1 && availableErrors == 1) {
                        availableErrors--;
                    } else {
                        isValid = false;
                        break;
                    }
                }
            }

            if (!isValid) {
                isValid = true;
                final long maxFreq = values.stream().max(Long::compareTo)
                        .orElseThrow(IllegalStateException::new);
                availableErrors = 1;
                for (Long f : values) {
                    if (f != maxFreq && f != 1) {
                        isValid = false;
                        break;
                    }
                    if (f != maxFreq) {
                        if (availableErrors == 1) {
                            availableErrors--;
                        } else {
                            isValid = false;
                            break;
                        }
                    }
                }
            }

            return isValid ? "YES" : "NO";
        }
    }


    private static Map<Character, Long> freqMap(final String s) {
        return s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}

public class SherlockValidString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        String result = Result.isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
