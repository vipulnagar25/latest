package problemSolution.arrayp;

public class TrappingRainWaterProblem {
  public static int trap(int[] height) {
    int result = 0;
    for (int i = 1; i < height.length - 1; i++) {
      int leftMax = 0;
      for (int j = i; j >= 0; j--) {
        leftMax = Math.max(leftMax, height[j]);
      }
      int rightMax = 0;
      for (int k = i; k < height.length; k++) {
        rightMax = Math.max(rightMax, height[k]);
      }
      result += Math.min(leftMax, rightMax) - height[i];
    }

    return result;
  }

  public static int trapByPrefixAndSuffix(int[] height) {
    int n = height.length;
    int result = 0;
    int[] leftMax = new int[n];
    int[] rightMax = new int[n];
    leftMax[0] = height[0];
    for (int i = 1; i < n; i++) {
      leftMax[i] = Math.max(leftMax[i - 1], height[i]);
    }
    rightMax[n - 1] = height[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      rightMax[i] = Math.max(rightMax[i + 1], height[i]);
    }
    for (int i = 0; i < n; i++) {
      result += Math.min(leftMax[i], rightMax[i]) - height[i];
    }

    return result;
  }

  public static int trapByTwoPointer(int[] height) {
    int n = height.length;
    int left = 0;
    int right = n - 1;
    int leftMax = 0;
    int rightMax = 0;
    int result = 0;
    while (left < right) {
      leftMax = Math.max(leftMax, height[left]);
      rightMax = Math.max(rightMax, height[right]);
      if (leftMax < rightMax) {
        result = result + leftMax - height[left];
        left++;
      } else {
        result = result + rightMax - height[right];
        right--;
      }
    }

    return result;
  }

  static void main() {
    int[] arr = {2, 1, 5, 3, 1, 0, 4};
    // {4, 2, 3, 4};
    // {3, 0, 2, 0, 4};
    // {3, 0, 1, 0, 4, 0, 2}; // output 10
    System.out.println(trap(arr));
    System.out.println(trapByPrefixAndSuffix(arr));
    System.out.println(trapByTwoPointer(arr));
  }
}
