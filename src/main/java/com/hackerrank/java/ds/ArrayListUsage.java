package com.hackerrank.java.ds;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListUsage {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedInputStream(System.in))) {
            final int n = scanner.nextInt();
            List<List<Integer>> storage = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                final int size = scanner.nextInt();
                final ArrayList<Integer> array = size > 0 ? new ArrayList<>(size) : new ArrayList<>();
                for (int j = 0; j < size; j++) {
                    array.add(scanner.nextInt());
                }
                storage.add(array);
            }
            final int queriesCount = scanner.nextInt();
            for (int i = 0; i < queriesCount; i++) {
                final int arrayPosition = scanner.nextInt();
                final int elementPosition = scanner.nextInt();
                if (arrayPosition > 0 && arrayPosition <= storage.size() &&
                        elementPosition > 0 && elementPosition <= storage.get(arrayPosition - 1).size()) {
                    System.out.println(storage.get(arrayPosition - 1).get(elementPosition - 1));
                } else {
                    System.out.println("ERROR!");
                }
            }
        }
    }
}
