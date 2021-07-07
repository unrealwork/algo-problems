package com.hackerrank.algorithms.strings;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;


public class Encryption {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    private static class Result {

        /*
         * Complete the 'encryption' function below.
         *
         * The function is expected to return a STRING.
         * The function accepts STRING s as parameter.
         */

        public static String encryption(String s) {
            // Write your code here
            final String noWhitespaces = s.replace("\\w+", "");
            final double sqrt = Math.sqrt(noWhitespaces.length());
            final int columns = (int) Math.ceil(sqrt);
            final int rows = (int) Math.floor(sqrt);
            int j = 0;
            int i = 0;
            final char[][] symbols = new char[rows * columns < noWhitespaces.length() ? rows + 1 : rows][columns];
            for (int i1 = 0; i1 < symbols.length; i1++) {
                Arrays.fill(symbols[i1], ' ');
            }
            for (int k = 0; k < noWhitespaces.length(); k++) {
                final char c = noWhitespaces.charAt(k);
                symbols[i][j] = c;
                j++;
                if (j == columns) {
                    j = 0;
                    i++;
                }
            }
            final StringBuilder sb = new StringBuilder();
            for (int ii = 0; ii < columns; ii++) {
                boolean isLastExist = true;
                for (int jj = 0; jj < symbols.length; jj++) {
                    sb.append(symbols[jj][ii]);
                    if (symbols[jj][ii] == ' ') {
                        isLastExist = false;
                        break;
                    }
                }
                if (isLastExist) {
                    sb.append(' ');
                }
            }
            return sb.toString().trim();
        }

    }
}

