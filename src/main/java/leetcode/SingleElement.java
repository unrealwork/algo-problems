package leetcode;

public class SingleElement {

  public static int singleNonDuplicate(int[] nums) {
    return singleNonDuplicate(nums, 0, nums.length - 1);
  }

  private static int singleNonDuplicate(int[] nums, int left, int right) {
    if (left == right) {
      return nums[left];
    } else {
      int i = (right - left) / 2;
      int mid = i + left;

      if (i % 2 == 0) {
        if (nums[mid - 1] == nums[mid]) {
          return singleNonDuplicate(nums, left, mid - i % 2);
        } else {
          if (nums[mid] == nums[mid + 1]) {
            return singleNonDuplicate(nums, mid + i % 2, right);
          }
        }
      } else {
        if (nums[mid - 1] == nums[mid]) {
          return singleNonDuplicate(nums, mid + i % 2, right);
        } else {
          if (nums[mid] == nums[mid + 1]) {
            return singleNonDuplicate(nums, left, mid - i % 2);
          }
        }
      }
      return nums[mid];
    }
  }
}
