package com.leetcode.search;


public abstract class FirstBadVersion implements VersionControl {
    public int firstBadVersion(int totalVersions) {
        return searchBadVersion(1, totalVersions + 1) ;
    }

    private int searchBadVersion(int lowIndex, int highIndex) {
        int middleIndex = lowIndex + (highIndex - lowIndex) / 2;
        if (!isBadVersion(middleIndex) && isBadVersion(middleIndex + 1)) {
            return middleIndex + 1;
        }
        if (isBadVersion(middleIndex) && !isBadVersion(middleIndex - 1)) {
            return middleIndex;
        }
        return isBadVersion(middleIndex) ? searchBadVersion(lowIndex, middleIndex) : searchBadVersion(middleIndex + 1, highIndex);
    }
}
