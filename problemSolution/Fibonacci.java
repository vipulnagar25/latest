package problemSolution;

import java.util.Arrays;

public class Fibonacci {
  public static int fib(int n) { // this also bottom  but optimal for space
    if (n <= 1) return n;
    // stores current Fibonacci number
    int curr = 0;
    // To store the previous
    // two Fibonacci numbers
    int prev1 = 1;
    int prev2 = 0;
    for (int i = 2; i <= n; i++) {
      curr = prev1 + prev2;

      // Update previous two Fibonacci
      // numbers for next number
      prev2 = prev1;
      prev1 = curr;
    }
    return curr;
  }

  static int nthFibonacci(int n) {
    // base case
    if (n <= 1) {
      return n;
    }
    // sum of the two preceding
    // Fibonacci numbers
    return nthFibonacci(n - 1) + nthFibonacci(n - 2);
  }

  static int fibByBottomUp(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

  static int fibByTopDown(int n, int[] dp) {
    if (n <= 1) {
      return n;
    }
    if (dp[n] != -1) {
      return dp[n];
    }
    return dp[n] = fibByTopDown(n - 1, dp) + fibByTopDown(n - 2, dp);
  }

  static void main() {
    int n = 10;
    System.out.println("Fibonacci series up to " + n + " terms:");
    System.out.println();
    System.out.println(fib(n));
    System.out.println(nthFibonacci(n));
    System.out.println(fibByBottomUp(n));
    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);
    System.out.println(fibByTopDown(n, dp));
  }
}
