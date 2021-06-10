package com.hackerrank.algorithms.implementation;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class FairRations {
    static Optional<Long> fairRations(int[] B) {
        // Complete this function
        long sum = Arrays.stream(B).sum();
        int[] copyB = Arrays.copyOf(B, B.length);
        if (sum % 2 == 1) {
            return Optional.empty();
        }
        long count = 0;
        for (int i = 1; i < copyB.length; i++) {
            if (copyB[i - 1] % 2 == 1 && copyB[i] % 2 == 1) {
                copyB[i - 1]++;
                copyB[i]++;
                count+=2;
            }
        }
        long oddCount = Arrays.stream(copyB).filter(e -> e % 2 == 1).count();
        return Optional.of(count + oddCount * 2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] B = new int[N];
        for (int B_i = 0; B_i < N; B_i++) {
            B[B_i] = in.nextInt();
        }
        Optional<Long> result = fairRations(B);
        if (!result.isPresent()) {
            System.out.println("NO");
        } else {
            System.out.println(result.get());
        }
        in.close();
    }
}
