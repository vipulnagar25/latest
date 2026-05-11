package problemSolution.dpp;

import java.util.Arrays;

public class RodCutting {
  private static int cutRodByRecursion(int[] prices, int n) {

    if (n == 0) return 0;
    if (n == 1) return prices[0];

    return Math.max(cutRodByRecursion(prices, n - 1), cutRodByRecursion(prices, n));
  }

  private static int cutRod(int[] prices, int n) {
    int[] dp = new int[n + 1];

    // Find maximum value for all
    // rod of length i.
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        dp[i] = Math.max(dp[i], prices[j - 1] + dp[i - j]);
      }
    }
    System.out.println("dp array: " + Arrays.toString(dp));
    return dp[n];
  }

  static void main() {
    int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
    int n = prices.length;
    System.out.println(cutRod(prices, n));
    System.out.println(cutRodByRecursion(prices, n));
    // Expected: 22 (cut into lengths of 2 and 6)
  }
}
