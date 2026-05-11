package problemSolution.dpp;

import java.util.Arrays;

public class HouseRobber {
  private static int robByRecursion(int index, int[] nums) {
    if (index == 0) {
      return nums[0];
    }
    if (index < 0) {
      return 0;
    }
    return Math.max(nums[index] + robByRecursion(index - 2, nums), robByRecursion(index - 1, nums));
  }

  private static int robByRecursionByTopDown(int[] nums, int index, int[] dp) {
    if (index == 0) {
      return nums[0];
    }
    if (index == 1) {
      return Math.max(nums[0], nums[1]);
    }
    if (index < 0) {
      return 0;
    }
    if (dp[index] != -1) {
      return dp[index];
    }
    return dp[index] =
        Math.max(nums[index] + robByRecursion(index - 2, nums), robByRecursion(index - 1, nums));
  }

  private static int robByRecursionByBottomUp(int[] nums) {
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < nums.length; i++) {

      dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
    }
    return dp[nums.length - 1];
  }

  static void main() {
    int[] nums = {6, 7, 1, 3, 8, 2, 4};
    System.out.println(robByRecursion(nums.length - 1, nums));

    int dp[] = new int[nums.length + 1];
    Arrays.fill(dp, -1);
    System.out.println(robByRecursionByTopDown(nums, nums.length - 1, dp));
    // Expected: 4 (rob house 1 and house 3)
    System.out.println(robByRecursionByBottomUp(nums));
  }
}
