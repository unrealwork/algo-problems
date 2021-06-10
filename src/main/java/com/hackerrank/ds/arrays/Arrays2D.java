package com.hackerrank.ds.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


public class Arrays2D {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        bufferedReader.close();
        System.out.println(greaterHourGlass(arr));
    }

    static int greaterHourGlass(List<List<Integer>> arr) {
        Integer maxSize = null;
        for (int i = 0; i < arr.size() - 2; i++) {
            for (int j = 0; j < arr.get(i).size() - 2; j++) {
                int size = countHourGlass(arr, i, j);
                if (maxSize == null || maxSize < size) {
                    maxSize = size;
                }
            }
        }
        if (maxSize == null) {
            throw new IllegalStateException("At least one hourglass should exist");
        }
        return maxSize;
    }

    private static int countHourGlass(List<List<Integer>> arr, int startI, int startJ) {
        int res = 0;
        for (int i = startI; i < startI + 3; i++) {
            for (int j = startJ; j < startJ + 3; j++) {
                final int normalizedI = i - startI;
                final int normalizedJ = j - startJ;
                if (!(normalizedI == 1 && normalizedJ == 0 || normalizedI == 1 && normalizedJ == 2)) {
                    res += arr.get(i).get(j);
                }
            }
        }
        return res;
    }
}

