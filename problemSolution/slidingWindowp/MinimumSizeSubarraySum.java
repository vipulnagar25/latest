package problemSolution.slidingWindowp;

public class MinimumSizeSubarraySum {
    public static int minSubArrayLen(int target, int[] nums) {
        int answer = Integer.MAX_VALUE;
        int windowSum = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            windowSum += nums[right];
            while (windowSum >= target) {
                answer = Math.min(answer, right - left + 1);
                windowSum -= nums[left++];
            }

        }

        return answer == Integer.MAX_VALUE ? 0 : answer;

    }

    static void main() {
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int target = 11;
        System.out.println(minSubArrayLen(target, nums));
    }
}
