package problemSolution.arrayp;

public class MaximumSubarray {

  public int maxSubArray(int[] nums) {
    int currentSum = nums[0];
    int maxSum = nums[0];
    for (int i = 1; i < nums.length; i++) {
      currentSum = Math.max(nums[i], currentSum + nums[i]);
      System.out.println(currentSum);
      maxSum = Math.max(maxSum, currentSum);
    }

    return maxSum;
  }

  public static void main(String[] args) {
    MaximumSubarray solution = new MaximumSubarray();
    int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4}; // Expected: 6 (from [4, -1, 2, 1])
    System.out.println("Max subarray sum for nums1: " + solution.maxSubArray(nums1));

    int[] nums2 = {1}; // Expected: 1
    System.out.println("Max subarray sum for nums2: " + solution.maxSubArray(nums2));

    int[] nums3 = {5, 4, -1, 7, 8}; // Expected: 23 (from [5, 4, -1, 7, 8])
    System.out.println("Max subarray sum for nums3: " + solution.maxSubArray(nums3));

    int[] nums4 = {-1, -2, -3, -4}; // Expected: -1
    System.out.println("Max subarray sum for nums4: " + solution.maxSubArray(nums4));
  }
}
