package com.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

class FruitBasket {
    private FruitBasket() {
    }

    public static int totalFruit(int[] fruits) {
        int best = 0;
        int current = 0;
        Map<Integer, Integer> lastIndex = new HashMap<>(2);
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < fruits.length; windowEnd++) {
            int curFruit = fruits[windowEnd];
            if (!lastIndex.containsKey(curFruit) && lastIndex.size() == 2) {
                best = Math.max(best, current);
                while (windowStart < lastIndex.get(fruits[windowStart])) {
                    current--;
                    windowStart++;
                }
                lastIndex.remove(fruits[windowStart]);
                current--;
                windowStart++;
            }
            lastIndex.put(fruits[windowEnd], windowEnd);
            current++;
        }
        best = Math.max(best, current);
        return best;
    }
}
