package com.hackerrank.java.exceptions;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class TryCatch {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new BufferedInputStream(System.in))) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a / b);
        } catch (java.util.InputMismatchException e) {
            System.out.println(e.getClass().getName());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
