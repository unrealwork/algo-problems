package com.hackerrank.ds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3 
     */

    public static long equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
        final LinkedList<Integer> s1 = new LinkedList<>(h1);
        long sum1 = h1.stream().mapToInt(Integer::valueOf).sum();
        final LinkedList<Integer> s2 = new LinkedList<>(h2);
        long sum2 = h2.stream().mapToInt(Integer::valueOf).sum();
        final LinkedList<Integer> s3 = new LinkedList<>(h3);
        long sum3 = h3.stream().mapToInt(Integer::valueOf).sum();


        while (!s1.isEmpty() && !s2.isEmpty() && !s3.isEmpty()) {
            if (sum1 == sum2 && sum1 == sum3) {
                return sum1;
            }
            if (sum1 >= sum2 && sum1 >= sum3) {
                sum1 -= s1.removeFirst();
            } else {
                if (sum2 >= sum1 && sum2 >= sum3) {
                    sum2 -= s2.removeFirst();
                } else {
                    sum3 -= s3.removeFirst();
                }
            }
        }
        return 0;
    }

}

public class EqualStacks {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        long result = Result.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
