package org.hyperskill;


class StringUtils {

    private StringUtils() {

    }

    static int[] prefixFunction(final String s) {
        int[] p = new int[s.length()];
        if (p.length > 1) {
            for (int i = 1; i < p.length; i++) {
                if (s.charAt(i) == s.charAt(p[i - 1])) {
                    p[i] = p[i - 1] + 1;
                } else {
                    p[i] = 0;
                }
            }
        }
        return p;
    }

    static int kmp(final String text, final String pattern) {
        final int[] p = prefixFunction(pattern);
        int i = 0;
        final int textSize = text.length();
        final int patternSize = pattern.length();
        while (i < textSize) {
            int j = 0;
            int k = i;
            while (text.charAt(k) == pattern.charAt(j)) {
                j++;
                k++;
                if (j == patternSize) {
                    return k - patternSize;
                }
                if (k == textSize) {
                    return -1;
                }
            }
            i += (p[j] + 1);
        }
        return -1;
    }
}
