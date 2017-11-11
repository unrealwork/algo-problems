package leetcode;

public class MinSubSequenceSize {

  public static int minSubArrayLen(int s, int[] nums) {
    long lastSum = 0l;
    int bestRes;
    long curSum = 0l;
    int i = 0;
    while (curSum < s) {
      if (i == nums.length) {
        return 0;
      }
      curSum += nums[i];
      i++;
    }
    bestRes = i;
    for (int j = 0; j < nums.length; j++) {
      curSum -= nums[j];
      while (curSum < s) {
        if (i == nums.length) {
          return bestRes;
        }
        curSum += nums[i];
        i++;
      }
      int length = i - j - 1;
      if (length < bestRes) {
        bestRes = length;
      }
    }
    return bestRes;
  }


  public static void main(String[] args) {
    System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
  }
}
