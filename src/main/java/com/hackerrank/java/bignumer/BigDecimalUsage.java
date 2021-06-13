package com.hackerrank.java.bignumer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Function;

public class BigDecimalUsage {


    public static void main(String[] args) {
        //Input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n + 2];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        sc.close();

        //Write your code here
        final Comparator<String> comparator = Comparator
                .comparing((Function<String, BigDecimal>) BigDecimal::new
                ).reversed();
        Arrays.sort(s, 0, n, comparator);
        //Output
        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }
    }
}
