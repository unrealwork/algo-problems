package com.leetcode;

public class KthSmallest {

  public int findKthLargest(int[] nums, int k) {
    int normIndex = nums.length - k;
    quickSelect(nums, 0, nums.length - 1, normIndex);
    return nums[normIndex];
  }

  private static void quickSelect(int[] arr, int li, int ri, int k) {
    if (li < ri) {
      int pivotIndex = partition(arr, li, ri, k);
      if (k == pivotIndex) {
        return;
      } else {
        if (k > pivotIndex) {
          quickSelect(arr, pivotIndex + 1, ri, k);
        } else {
          quickSelect(arr, li, pivotIndex - 1, k);
        }
      }
    }
  }


  private static int partition(int[] arr, int li, int ri, int k) {
    int j = li;
    int pivotIndex = li + (ri - li + 1) / 2;
    int pivot = arr[pivotIndex];
    exch(arr, pivotIndex, ri);
    for (int i = li; i <= ri; i++) {
      if (arr[i] < pivot) {
        exch(arr, i, j);
        j++;
      }
    }
    exch(arr, ri, j);
    // Find pivot nearest to kth element
    for (int i = j + 1; i <= ri && j < k && j < ri; i++) {
      if (arr[i] == arr[j]) {
        exch(arr, j + 1, i);
        j++;
      }
    }
    return j;
  }

  private static void exch(int[] ar, int j, int i) {
    int tmp = ar[i];
    ar[i] = ar[j];
    ar[j] = tmp;
  }
}
