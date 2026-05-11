package problemSolution.dpp;

import java.util.Arrays;

public class CoinChange {
  public static int coinChangeByBottomUp(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1); // large value
    System.out.println(Arrays.toString(dp));
    dp[0] = 0;

    for (int i = 1; i <= amount; i++) {
      for (int coin : coins) {
        if (coin <= i) {
          int min = Math.min(dp[i], dp[i - coin] + 1);
          dp[i] = min;
        }
      }
    }
    System.out.println(Arrays.toString(dp));
    return dp[amount] > amount ? -1 : dp[amount];
  }

  static void main() {

    int[] coins = {2, 5};
    int amount = 11;
    System.out.println(coinChangeByBottomUp(coins, amount)); // Expected: 3 (11 = 5 + 5 + 1)

    //    coins = new int[] {2};
    //    amount = 3;
    //    System.out.println(coinChange(coins, amount)); // Expected: -1 (not possible to make
    // change)
    //
    //    coins = new int[] {1};
    //    amount = 0;
    //    System.out.println(coinChange(coins, amount)); // Expected: 0 (no coins needed for amount
    // 0)
  }
}
