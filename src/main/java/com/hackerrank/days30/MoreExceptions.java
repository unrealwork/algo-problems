package com.hackerrank.days30;

import java.util.Scanner;
import java.util.stream.IntStream;

//Write your code here

class Calculator {
    public int power(int n, int p) {
        if (n > 0 && p > 0) {
            return IntStream.range(0, p).reduce(1,
                    (left, right) -> left * n);
        }
        throw new IllegalStateException("n and p should be non-negative");
    }
}


class MoreExceptions {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {

            int n = in.nextInt();
            int p = in.nextInt();
            Calculator myCalculator = new Calculator();
            try {
                int ans = myCalculator.power(n, p);
                System.out.println(ans);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        in.close();
    }
}
