package problemSolution.slidingWindowp;

public class MaximumAverageSubarrayI643 {
    public static double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double max = sum;
        for (int j = k; j < nums.length; j++) {
            sum = sum - nums[j - k] + nums[j]; // use sum, not max
            max = Math.max(max, sum);
        }
        return max / k;
    }

    static void main() {

        int[] array = {0,4,0,3,2};
        int k = 1;

        var result = findMaxAverage(array, k);
        System.out.println(result);

    }
}
