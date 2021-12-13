package com.leetcode.search;

import org.junit.Assert;
import org.junit.Test;

public class FirstBadVersionTest {

    @Test
    public void test() {
        testFirstBadVersion(4, 5);
    }

    @Test
    public void test1() {
        testFirstBadVersion(5, 5);
    }


    private void testFirstBadVersion(int expectedBadVersion, int totalVersions) {
        FirstBadVersion badVersion = new FirstBadVersion() {
            @Override
            public boolean isBadVersion(int version) {
                return version >= expectedBadVersion;
            }
        };

        int firstBadVersion = badVersion.firstBadVersion(totalVersions);
        Assert.assertEquals(expectedBadVersion, firstBadVersion);
    }
}
