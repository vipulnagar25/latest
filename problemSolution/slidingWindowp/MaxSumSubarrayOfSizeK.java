package problemSolution.slidingWindowp;

public class MaxSumSubarrayOfSizeK {
    private static int findMaxSumSubArray(int k, int[] nums) {
        if (k > nums.length || k <= 0) return 0;

        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int left = 0;

        // Calculate sum of first window
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        maxSum = windowSum;

        // Slide the window
        for (int i = k; i < nums.length; i++) {
            windowSum = windowSum + nums[i] - nums[left++];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {100, 200, 300, 400};
        int k = 2;
        System.out.println(findMaxSumSubArray(k, nums));
    }


}
