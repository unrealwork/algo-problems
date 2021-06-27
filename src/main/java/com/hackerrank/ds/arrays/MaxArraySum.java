package com.hackerrank.ds.arrays;

import java.io.*;
import java.util.Scanner;

public class MaxArraySum {

    // Complete the maxSubsetSum function below.
    static long maxSubsetSum(int[] arr) {
        long max = 0; // empty subset
        long[][] d = new long[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int step = 1;  i + step < arr.length; step++) {
                d[i][step] = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
            for (int step = 2; step <= i && i - step > -1; step++) {
                d[i - step][step] += arr[i];
                if (d[i - step][step] > max) {
                    max = d[i - step][step];
                }
            }
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        long res = maxSubsetSum(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
