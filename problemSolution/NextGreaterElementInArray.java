package problemSolution.arrayp;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementInArray {
  private static int[] nextGreaterElementByBruteForce(int[] nums) {
    int n = nums.length;

    int[] res = new int[n];
    for (int i = 0; i < n; i++) {
      res[i] = -1;
      for (int j = i + 1; j < n; j++) {
        if (nums[i] < nums[j]) {
          res[i] = nums[j];
          break;
        }
      }
    }
    return res;
  }

  private static int[] nextGreaterElementByStack(int[] nums) {
    int n = nums.length;
    int[] res = new int[n];
    Arrays.fill(res, -1);
    Stack<Integer> stack = new Stack<>();
    for (int i = n - 1; i >= 0; i--) {
      while (!stack.isEmpty() && stack.peek() <= nums[i]) {
        stack.pop();
      }
      if (!stack.isEmpty()) {
        res[i] = stack.peek();
      }
      stack.push(nums[i]);
    }

    return res;
  }

  static void main() {
    int[] nums = {13, 7, 6, 12};
    int[] result = nextGreaterElementByBruteForce(nums);
    System.out.println(Arrays.toString(result));
    int[] result1 = nextGreaterElementByStack(nums);
    System.out.println(Arrays.toString(result1));
  }
}
