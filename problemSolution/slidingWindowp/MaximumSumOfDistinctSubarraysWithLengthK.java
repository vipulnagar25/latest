package problemSolution.slidingWindowp;

import java.util.HashMap;
import java.util.Map;

public class MaximumSumOfDistinctSubarraysWithLengthK {
    public static long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        long windowSum = 0;
        long maxSum = 0;

        for (int i = 0; i < nums.length; i++) {
            // Add current element
            windowSum += nums[i];
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);

            // Remove element if window size exceeds k
            if (i >= k) {
                windowSum -= nums[i - k];
                freq.put(nums[i - k], freq.get(nums[i - k]) - 1);

                if (freq.get(nums[i - k]) == 0) {
                    freq.remove(nums[i - k]);
                }
            }

            // Check valid window
            if ( i >= k - 1 && freq.size() == k) {
                maxSum = Math.max(maxSum, windowSum);
            }
        }

        return maxSum;
    }

    static void main() {

        int[] nums = {1,5,4,2,9,9,9};
        int k = 3;
        System.out.println(maximumSubarraySum(nums, k));
    }
}
