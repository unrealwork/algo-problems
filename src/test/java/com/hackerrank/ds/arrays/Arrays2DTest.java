package com.hackerrank.ds.arrays;

import org.junit.Test;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Arrays2DTest {

    @Test
    public void greaterHourGlass() {
        final List<List<Integer>> arr = Arrays.stream(new int[][] {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        }).map(nums -> Arrays.stream(nums).boxed().collect(Collectors.toList()))
                .collect(Collectors.toList());

        Assert.assertEquals(Arrays2D.greaterHourGlass(arr), 19);
    }
}
