package com.hackerrank.algorithms.implementation;

import com.hackerrank.algorithms.implementation.QueensAttack2.Path;
import com.hackerrank.algorithms.implementation.QueensAttack2.Position;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.apache.commons.lang3.ArrayUtils.toArray;

public class QueensAttack2Test {

    @DataProvider
    public static Object[][] pathCases() {
        return new Object[][] {
                pathCase(Path.VERTICAL_UP, Position.of(2, 1), Position.of(2, 3), true),
                pathCase(Path.VERTICAL_UP, Position.of(2, 1), Position.of(2, 0), false),
                pathCase(Path.VERTICAL_DOWN, Position.of(2, 1), Position.of(2, 3), false),
                pathCase(Path.VERTICAL_DOWN, Position.of(2, 1), Position.of(2, 0), true),
                pathCase(Path.HORIZONTAL_LEFT, Position.of(2, 1), Position.of(1, 1), true),
                pathCase(Path.HORIZONTAL_LEFT, Position.of(2, 1), Position.of(5, 1), false),
                pathCase(Path.HORIZONTAL_RIGHT, Position.of(2, 1), Position.of(1, 1), false),
                pathCase(Path.HORIZONTAL_RIGHT, Position.of(2, 1), Position.of(5, 1), true),
                pathCase(Path.MAIN_DIAG_DOWN, Position.of(2, 1), Position.of(4, 3), false),
                pathCase(Path.MAIN_DIAG_DOWN, Position.of(2, 1), Position.of(1, 0), true),
                pathCase(Path.ADD_DIAG_UP, Position.of(2, 1), Position.of(3, 0), true),
                pathCase(Path.ADD_DIAG_UP, Position.of(2, 1), Position.of(1, 2), false),
                pathCase(Path.ADD_DIAG_DOWN, Position.of(2, 1), Position.of(3, 0), false),
                pathCase(Path.ADD_DIAG_DOWN, Position.of(2, 1), Position.of(1, 2), true),
        };
    }

    @DataProvider
    public static Object[][] mainCases() {
        return new Object[][]{
                toArray(Position.of(3,2), 5, new int[][]{}, 14),
                toArray(Position.of(2,2), 5, new int[][]{}, 16),
                toArray(Position.of(2,2), 5, new int[][]{{3,2}}, 14),
                toArray(Position.of(3,3), 4, new int[][]{}, 9)
        };
    }


    @Test(dataProvider = "pathCases")
    public void pathChecker(final Path path, final Position queenPostion, final Position obstaclePosition, final boolean isBeaten) {
        Assert.assertEquals(path.isBeatenByQueen(queenPostion, obstaclePosition), isBeaten);
    }

    @Test(dataProvider = "distCases")
    public void pathChecker(final Position queenPosition, final Position obstaclePosition, final int dist) {
        Assert.assertEquals(QueensAttack2.dist(queenPosition, obstaclePosition), dist);
    }

    @Test(dataProvider = "mainCases")
    public void testQueenAttack(final Position qP,final int n, final int[][] obstacles, final int expectedResult) {
        final int result = QueensAttack2.queensAttack(n, obstacles.length, qP.getX(), qP.getY(), obstacles);
        Assert.assertEquals(result, expectedResult);
    }

    @DataProvider
    private static Object[][] distCases() {
        return new Object[][] {
                toArray(Position.of(2, 1), Position.of(1, 1), 0),
                toArray(Position.of(2, 1), Position.of(2, 3), 1)
        };
    }

    private static Object[] pathCase(final Path path, final Position queenPostion, final Position obstaclePosition, final boolean isBeaten) {
        return toArray(path, queenPostion, obstaclePosition, isBeaten);
    }
}