package com.hackerrank.algorithms.recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Result {

    /*
     * Complete the 'stepPerms' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    private static final long MOD = 10000000007L;

    public static long stepPerms(int n) {
        // Write your code here
        long[] d = new long[n];

        for (int j = 0; j < Math.min(3, n); j++) {
            d[j] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (i > j) {
                    d[i] += d[i - j - 1];
                }
                d[i] %= MOD;
            }
        }
        return d[n - 1];
    }

}

public class DavisStaircase {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int s = Integer.parseInt(bufferedReader.readLine().trim());

        for (int sItr = 0; sItr < s; sItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            long res = Result.stepPerms(n);

            bufferedWriter.write(String.valueOf(res));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
