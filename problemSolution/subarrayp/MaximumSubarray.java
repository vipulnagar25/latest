package problemSolution.subarrayp;

public class MaximumSubarray {

  public static int maxSubArrayByBruteForce(int[] nums) {
    int result = nums[0];
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      int sum = 0;
      for (int j = i; j < n; j++) {
        sum = sum + nums[j];
        result = Math.max(result, sum);
      }
    }
    return result;
  }

  public static int maxSubArray(int[] nums) // Using Kadane's Algorithm - O(n) Time and O(1) Space
      {
    int currentSum = 0;
    int maxSum = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      currentSum = currentSum + nums[i];
      maxSum = Math.max(maxSum, currentSum);
      if (currentSum < 0) {
        currentSum = 0;
      }
    }

    return maxSum;
  }

  public static void main(String[] args) {

    int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4}; // Expected: 6 (from [4, -1, 2, 1])
    System.out.println("Max subarray sum for nums1: " + maxSubArray(nums1));

    int[] nums2 = {1}; // Expected: 1
    System.out.println("Max subarray sum for nums2: " + maxSubArray(nums2));

    int[] nums3 = {5, 4, -1, 7, 8}; // Expected: 23 (from [5, 4, -1, 7, 8])
    System.out.println("Max subarray sum for nums3: " + maxSubArray(nums3));

    int[] nums4 = {-2, -3, -1, -4}; // Expected: -1
    System.out.println("Max subarray sum for nums4: " + maxSubArray(nums4));
    int[] nums5 = {2, 3, -8, 7, -1, 2, 3};
    System.out.println("Max subarray sum for nums5: " + maxSubArrayByBruteForce(nums5));
  }
}
