package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

public class JumpingOnTheClouds {
    static int jumpingOnClouds(int[] c) {
        // Complete this function
        int count = 0;
        int currentCloud = 0;
        int goal = c.length - 1;
        while (currentCloud != goal) {
            if (goal - currentCloud < 3) {
                currentCloud = goal;
            } else {
                if (c[currentCloud + 2] != 1) {
                    currentCloud += 2;
                } else {
                    currentCloud++;
                }
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] c = new int[n];
        for (int c_i = 0; c_i < n; c_i++) {
            c[c_i] = in.nextInt();
        }
        int result = jumpingOnClouds(c);
        System.out.println(result);
        in.close();
    }
}
