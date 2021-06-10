package com.hackerrank.days30;


import java.util.Scanner;


class Difference {
    private int[] elements;
    public int maximumDifference = -1;

    public Difference(int[] elements) {
        this.elements = elements;
    }

    public void computeDifference() {
        maximumDifference = Math.abs(elements[0] - elements[1]);
        for (int i = 0; i < elements.length; i++) {
            for (int j = i + 1; j < elements.length; j++) {
                if (i != j) {
                    final int diff = Math.abs(elements[i] - elements[j]);
                    if (maximumDifference < 0 || diff > maximumDifference) {
                        maximumDifference = diff;
                    }
                }
            }
        }
    }
} // End of Difference class

public class Scope {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}