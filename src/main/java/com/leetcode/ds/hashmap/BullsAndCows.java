package com.leetcode.ds.hashmap;

class BullsAndCows {
    private BullsAndCows() {

    }

    public static String getHint(String secret, String guess) {
        int[] bulls = new int[10];
        int[] counterS = new int[10];
        int[] counterG = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int digitS = secret.charAt(i) - '0';
            int digitG = guess.charAt(i) - '0';
            if (digitG == digitS) {
                bulls[digitS]++;
            }
            counterS[digitS]++;
            counterG[digitG]++;
        }
        int bullsCount = 0;
        int cowsCount = 0;
        for (int i = 0; i < counterS.length; i++) {
            bullsCount += bulls[i];
            int cows = Math.min(counterS[i], counterG[i]) - bulls[i];
            cowsCount += cows;
        }
        return bullsCount + "A" + cowsCount + "B";
    }
}
