package problemSolution.dpp;

import java.util.Arrays;

public class ClimbingStairsStep2 {

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

    return dp[n] = climbStairsByTopDown(n - 1, dp) + climbStairsByTopDown(n - 2, dp);
  }

  private static int climbStairsByBottomUp(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {

      dp[i] = dp[i - 1] + dp[i - 2];
    }

    return dp[n];
  }

  private static int climbStairsByBottomUpOptimal(int n) {
    if (n < 0) {
      return 0;
    }
    int current = 1;
    int prev1 = 1;
    int prev2 = 1;
    for (int i = 2; i <= n; i++) {
      current = prev1 + prev2;
      prev1 = prev2;

      prev2 = current;
    }
    return current;
  }

  static void main() {
    int n = 5;
    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);
    System.out.println(climbStairsByTopDown(n, dp)); // Expected: 8
    System.out.println(climbStairsByBottomUp(n));
    System.out.println(climbStairsByBottomUpOptimal(n));
  }
}
