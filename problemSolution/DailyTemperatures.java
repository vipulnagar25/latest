package problemSolution.arrayp;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

  private static int[] dailyTemperatures(int[] temperatures) {
    int n = temperatures.length;
    int[] res = new int[n];

    for (int i = 0; i < n; i++) {
      res[i] = -1;
      for (int j = i + 1; j < n; j++) {
        if (temperatures[j] > temperatures[i]) {
          res[i] = j - i;
          break;
        }
      }
    }

    return res;
  }

  private static int[] dailyTemperaturesByStack(int[] temperatures) {
    int n = temperatures.length;
    int[] res = new int[n];
    Arrays.fill(res, -1);
    Stack<Integer> stack = new Stack<>();
    for (int i = n - 1; i >= 0; i--) {
      while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
        stack.pop();
      }
      if (!stack.isEmpty()) {
        res[i] = stack.peek() - i;
      }
      stack.push(i);
    }

    return res;
  }

  static void main() {

    int[] temperatures = // {75, 74, 73, 72};
        {73, 74, 75, 71, 69, 72, 76, 73};
    int[] result = dailyTemperatures(temperatures);
    System.out.println(Arrays.toString(result));
    int[] result1 = dailyTemperatures(temperatures);
    System.out.println(Arrays.toString(result1));
  }
}
