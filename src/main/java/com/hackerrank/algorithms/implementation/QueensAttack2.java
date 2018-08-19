package com.hackerrank.algorithms.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;

public class QueensAttack2 {

    private static final Scanner scanner = new Scanner(System.in);
    // Complete the queensAttack function below.

    static int queensAttack(int n, int k, int qX, int qY, int[][] obstacles) {
        final Map<Path, Integer> pathDistMap = new EnumMap<>(Path.class);
        pathDistMap.put(Path.VERTICAL_UP, n - qY - 1);
        pathDistMap.put(Path.VERTICAL_DOWN, qY);
        pathDistMap.put(Path.HORIZONTAL_RIGHT, n - qX - 1);
        pathDistMap.put(Path.HORIZONTAL_LEFT, qX);
        pathDistMap.put(Path.MAIN_DIAG_UP, Math.min(n - qX, n - qY) - 1);
        pathDistMap.put(Path.MAIN_DIAG_DOWN, Math.min(qX, qY) - 1);
        pathDistMap.put(Path.ADD_DIAG_UP, Math.min(n - qX, n - qY));
        pathDistMap.put(Path.ADD_DIAG_DOWN, Math.min(qX, qY) - 1);
        final Position queenPosition = Position.of(qX, qY);
        Arrays.stream(obstacles)
                .map(arr -> Position.of(arr[0], arr[1]))
                .forEach(pos -> Arrays.stream(Path.values())
                        .filter(p -> p.isBeatenByQueen(queenPosition, pos))
                        .findAny()
                        .ifPresent(path -> refreshDisanceMap(pathDistMap, queenPosition, pos, path)));
        return pathDistMap.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static void refreshDisanceMap(Map<Path, Integer> pathDistMap, Position queenPosition, Position pos, Path path) {
        final int d = dist(queenPosition, pos);
        final int curDist = pathDistMap.get(path);
        if (curDist > d) {
            pathDistMap.put(path, d);
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            String[] queenPositionString = scanner.nextLine().split(" ");

            int queenX = Integer.parseInt(queenPositionString[0]) - 1;

            int queenY = Integer.parseInt(queenPositionString[1]) - 1;

            int[][] obstacles = new int[k][2];

            for (int i = 0; i < k; i++) {
                String[] obstaclesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                    obstacles[i][j] = obstaclesItem - 1;
                }
            }

            int result = queensAttack(n, k, queenX, queenY, obstacles);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

        }

        scanner.close();
    }

    static int dist(final Position queenPostion, final Position obstaclePosition) {
        return Math.max(Math.abs(queenPostion.getX() - obstaclePosition.getX()), Math.abs(obstaclePosition.getY() - queenPostion.getY())) - 1;
    }

    static class Position {
        private final int x;
        private final int y;

        private Position(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        public static Position of(final int x, final int y) {
            return new Position(x, y);
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    enum Path {
        VERTICAL_UP((qP, oP) -> qP.getX() == oP.getX() && oP.getY() > qP.getY()),
        VERTICAL_DOWN((qP, oP) -> qP.getX() == oP.getX() && oP.getY() < qP.getY()),
        HORIZONTAL_RIGHT((qP, oP) -> qP.getY() == oP.getY() && oP.getX() > qP.getX()),
        HORIZONTAL_LEFT((qP, oP) -> qP.getY() == oP.getY() && oP.getX() < qP.getX()),
        MAIN_DIAG_UP((qP, oP) -> diff(qP) == diff(oP) && oP.getX() > qP.getX()),
        MAIN_DIAG_DOWN((qP, oP) -> diff(qP) == diff(oP) && oP.getX() < qP.getX()),
        ADD_DIAG_UP((qP, oP) -> sum(qP) == sum(oP) && oP.getX() > qP.getX()),
        ADD_DIAG_DOWN((qP, oP) -> sum(qP) == sum(oP) && oP.getX() < qP.getX());

        private final BiFunction<Position, Position, Boolean> checker;

        Path(final BiFunction<Position, Position, Boolean> checker) {
            this.checker = checker;
        }

        public boolean isBeatenByQueen(final Position qP, final Position oP) {
            return checker.apply(qP, oP);
        }

        private static int diff(final Position position) {
            return position.getY() - position.getX();
        }

        private static int sum(final Position position) {
            return position.getY() + position.getX();
        }
    }
}
