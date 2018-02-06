package com.hackerrank.contest.w36;

import java.util.Scanner;

public class AcidNaming {
    static String acidNaming(String acidName) {
        // Complete this function
        if (acidName.endsWith("ic")) {
            if (acidName.startsWith("hydro")) {
                return "non-metal acid";
            } else {
                return "polyatomic acid";
            }
        } else {
            return "not an acid";
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int a0 = 0; a0 < n; a0++) {
            String acid_name = in.next();
            String result = acidNaming(acid_name);
            System.out.println(result);
        }
        in.close();
    }
}
