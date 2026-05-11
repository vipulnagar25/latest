package problemSolution.dpp;

import java.util.Arrays;

public class ClimbingStairsStep3 {
  private static int climbStairsByTopDown(int n, int[] dp) {

    if (n == 0) {
      return 1;
    }
    if (n < 0) {
      return 0;
    }

    if (dp[n] != -1) {
      return dp[n];
    }
    return dp[n] =
        climbStairsByTopDown(n - 1, dp)
            + climbStairsByTopDown(n - 2, dp)
            + climbStairsByTopDown(n - 3, dp);
  }

  private static int climbStairsByBottomUp(int n) {
    int[] dp = new int[n + 1];

    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
    }
    return dp[n];
  }

  static void main() {
    int n = 5;
    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);
    System.out.println(climbStairsByTopDown(n, dp)); // Expected: 8
    System.out.println(climbStairsByBottomUp(n));
  }
}
