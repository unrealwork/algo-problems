package com.hackerrank.java.ds;

import java.util.Scanner;

public class Array1D2 {

    private static class Solver {
        private final int leap;
        private final int[] game;
        private boolean[] canMoveLeaped;
        private boolean[] canMoveForward;
        private boolean[] canMoveBackward;
        private boolean[] visited;
        private Boolean canWin;

        private Solver(int leap, int[] game) {
            this.leap = leap;
            this.game = game;
            init();
        }

        private void init() {
            canMoveLeaped = new boolean[game.length];
            canMoveForward = new boolean[game.length];
            canMoveBackward = new boolean[game.length];
            visited = new boolean[game.length];
            for (int j = 0; j < game.length; j++) {
                if (game[j] == 0) {
                    canMoveForward[j] = true;
                    canMoveBackward[j] = true;
                    canMoveLeaped[j] = true;
                }
            }
            canMoveBackward[0] = false;
            canMoveForward[0] = true;
            canMoveLeaped[0] = true;
        }

        boolean canWin() {
            if (canWin == null) {
                // Return true if you can win the game; otherwise, return false.
                int i = 0;
                do {
                    final boolean res = solve(i);
                    if (res) {
                        canWin = true;
                        return true;
                    }
                    i = nextNotCovered();
                } while (i < game.length);
                canWin = false;
                return false;
            }
            return canWin;
        }

        private boolean solve(int i) {
            final int lastIndex = game.length - 1;
            while (i < lastIndex && (canMoveForward[i] || canMoveBackward[i] || canMoveLeaped[i])) {
                visited[i] = true;
                if (i + leap > lastIndex) {
                    return true;
                }
                canMoveLeaped[i] = false;
                if (canMoveLeaped[i + leap]) {
                    i += leap;
                    continue;
                }
                canMoveForward[i] = false;
                if (canMoveForward[i + 1]) {
                    i++;
                    continue;
                }
                canMoveBackward[i] = false;
                if (i > 0 && canMoveBackward[i - 1]) {
                    i--;
                    continue;
                }
                break;
            }
            if (i == lastIndex) {
                return game[i] == 0;
            }
            return (i > lastIndex);
        }

        private int nextNotCovered() {
            for (int i = 0; i < visited.length; i++) {
                if (visited[i] && (canMoveLeaped[i] || canMoveBackward[i] || canMoveForward[i])) {
                    return i;
                }
            }
            return game.length;
        }
    }

    public static boolean canWin(int leap, int[] game) {
        final Solver solver = new Solver(leap, game);
        return solver.canWin();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println((canWin(leap, game)) ? "YES" : "NO");
        }
        scan.close();
    }
}
