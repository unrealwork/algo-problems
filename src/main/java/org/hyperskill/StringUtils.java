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
}
