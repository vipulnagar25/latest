package problemSolution.dpp;

import java.util.Arrays;

public class CoinChangeCountWaysToMakeSum {
  private static int countWays(int[] coins, int amount) {

    return countRecur(coins, amount, coins.length);
  }

  static int countRecur(int[] coins, int sum, int index) {

    if (sum == 0) {
      return 1;
    }

    if (sum < 0 || index == 0) {
      return 0;
    }

    return countRecur(coins, sum - coins[index - 1], index) + countRecur(coins, sum, index - 1);
  }

  static int countByBottomUp(int[] coins, int sum) {
    int n = coins.length;
    int[] dp = new int[sum + 1];
    dp[0] = 1;
    for (int i = 0; i < n; i++) {
      for (int j = coins[i]; j <= sum; j++) {
         System.out.println(" j: " + j);
        dp[j] = dp[j] + dp[j - coins[i]];
      }
      System.out.println("end==========");
    }
    System.out.println(Arrays.toString(dp));
    return dp[sum];
  }

  static void main() {

    int[] coins = {1, 2, 3};
    int amount = 4;
    System.out.println(
        countWays(coins, amount)); // Expected: 4 (combinations: {1,1,1,1}, {1,1,2}, {1,3}, {2,2})
    System.out.println(countByBottomUp(coins, amount));
  }
}
