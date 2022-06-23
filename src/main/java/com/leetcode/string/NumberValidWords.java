package com.leetcode.string;

class NumberValidWords {
    private NumberValidWords() {

    }

    public static int countValidWords(String s) {
        int count = 0;
        boolean isWord = false;
        boolean isValid = true;
        int hyphenCount = 0;
        Validator validator = new Validator();
        int size = s.length();
        for (int i = 0; i < size; i++) {
            char c = s.charAt(i);
            if (!isWord && c != ' ') {
                isWord = true;
                validator.analyze(c);
            } else {
                if (c == ' ') {
                    isWord = false;
                    isValid = validator.validate();
                    if (isValid) {
                        System.out.println(s.substring(i - validator.wordSize, i));
                        count++;
                    }
                    validator.reset();
                } else {
                    validator.analyze(c);
                }
            }
        }
        if (validator.validate()) {
            count++;
        }
        return count;
    }

    private static class Validator {
        private int hyphenCount = 0;
        private int wordSize = 0;
        private char firstSymbol;
        private char lastSymbol;
        private boolean hasDigit = false;
        private int punctuationCount = 0;

        private int hyphenIndex = Integer.MIN_VALUE;

        public boolean validate() {
            return wordSize > 0 && !hasDigit
                    && hyphenCount <= 1 && firstSymbol != '-' && lastSymbol != '-'
                    && (punctuationCount == 0 || punctuationCount == 1 && isPunctuation(lastSymbol) && hyphenIndex != wordSize - 2);
        }

        public void analyze(char c) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
            lastSymbol = c;
            if (wordSize == 0) {
                firstSymbol = c;
            }
            if (c == '-') {
                hyphenIndex = wordSize;
                hyphenCount++;
            }

            if (isPunctuation(c)) {
                punctuationCount++;
            }
            wordSize++;
        }

        private boolean isPunctuation(char c) {
            return c == '!' || c == '.' || c == ',';
        }

        public void reset() {
            this.hyphenCount = 0;
            this.wordSize = 0;
            this.hasDigit = false;
            this.firstSymbol = 0;
            this.lastSymbol = 0;
            this.punctuationCount = 0;
            this.hyphenIndex = Integer.MIN_VALUE;
        }
    }

    public static void main(String[] args) {
        System.out.println(countValidWords(" 62   nvtk0wr4f  8 qt3r! w1ph 1l ,e0d 0n 2v 7c.  n06huu2n9 s9   ui4 nsr!d7olr  q-, vqdo!btpmtmui.bb83lf g .!v9-lg 2fyoykex uy5a 8v whvu8 .y sc5 -0n4 zo pfgju 5u 4 3x,3!wl  fv4   s  aig cf j1 a i  8m5o1  !u n!.1tz87d3 .9    n a3  .xb1p9f  b1i a j8s2 cugf l494cx1! hisceovf3 8d93 sg 4r.f1z9w   4- cb r97jo hln3s h2 o .  8dx08as7l!mcmc isa49afk i1 fk,s e !1 ln rt2vhu 4ks4zq c w  o- 6  5!.n8ten0 6mk 2k2y3e335,yj  h p3 5 -0  5g1c  tr49, ,qp9 -v p  7p4v110926wwr h x wklq u zo 16. !8  u63n0c l3 yckifu 1cgz t.i   lh w xa l,jt   hpi ng-gvtk8 9 j u9qfcd!2  kyu42v dmv.cst6i5fo rxhw4wvp2 1 okc8!  z aribcam0  cp-zp,!e x  agj-gb3 !om3934 k vnuo056h g7 t-6j! 8w8fncebuj-lq    inzqhw v39,  f e 9. 50 , ru3r  mbuab  6  wz dw79.av2xp . gbmy gc s6pi pra4fo9fwq k   j-ppy -3vpf   o k4hy3 -!..5s ,2 k5 j p38dtd   !i   b!fgj,nx qgif "));
    }
}
