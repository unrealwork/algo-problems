package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

public class MinimumDistances {
    static int minimumDistances(int[] a) {
        // Complete this function
        int minDistance = -1;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] == a[j]) {
                    int currentDist = j - i;
                    if (minDistance == -1 || minDistance > currentDist) {
                        minDistance = currentDist;
                    }
                }
            }
        }
        return minDistance;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        int result = minimumDistances(a);
        System.out.println(result);
        in.close();
    }
}
