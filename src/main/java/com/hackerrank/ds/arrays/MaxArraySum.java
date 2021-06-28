package com.hackerrank.ds.arrays;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class MaxArraySum {

    // Complete the maxSubsetSum function below.
    static long maxSubsetSum(int[] arr) {
        long[] d = new long[arr.length];
        d[0] = Math.max(arr[0], d[0]);
        d[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            d[i] = Math.max(arr[i], 0);
            d[i] = Math.max(d[i - 1], d[i - 2] + arr[i]);
            if (0 > d[i]) {
                d[i] = 0;
            }
        }
        return d[arr.length - 1];
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
