package com.hackerrank.java;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Currency {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        // Write your code here.
        final String us = NumberFormat.getCurrencyInstance(Locale.US)
                .format(payment);
        final String india = NumberFormat.getCurrencyInstance(new Locale("en","IN"))
                .format(payment);
        final String china = NumberFormat.getCurrencyInstance(Locale.CHINA)
                .format(payment);
        final String france = NumberFormat.getCurrencyInstance(Locale.FRANCE)
                .format(payment);

        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}