package problemSolution.subarrayp;

public class SplitAnArrayIntoTwoEqualSumSubarrays {

  private static boolean canSplitByBruteForce(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n - 1; i++) {
      int leftSum = 0;
      for (int j = 0; j <= i; j++) {
        leftSum = leftSum + nums[j];
      }
      System.out.println("leftSum: " + leftSum);
      int rightSum = 0;
      for (int j = i + 1; j < n; j++) {
        rightSum = rightSum + nums[j];
      }
      System.out.println("rightSum: " + rightSum);
      if (leftSum == rightSum) {
        return true;
      }
    }

    return false;
  }

  private static boolean canSplitOptimal(int[] nums) {
    int n = nums.length;
    int total = 0;

    for (int i = 0; i < n; i++) {
      total = total + nums[i];
    }

    int leftSum = 0;
    for (int i = 0; i < n; i++) {
      leftSum = leftSum + nums[i];
      int rightSum = total - leftSum;
      if (leftSum == rightSum) {
        return true;
      }
    }

    return false;
  }

  static void main() {
    int[] nums = {1, 2, 3, 4, 5, 5};
    System.out.println(canSplitByBruteForce(nums));
  }
}
