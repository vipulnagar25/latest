package problemSolution.subarrayp;

public class SubarrayOfSizeKWithGivenSum {
  private static boolean hasSubarrayOfSizeKWithGivenSumByBF(int[] nums, int k, int target) {
    int n = nums.length;
    for (int i = 0; i < n - k; i++) {
      int sum = nums[i];
      for (int j = i + 1; j < i + k; j++) {
        sum += nums[j];
      }
      if (sum == target) {
        return true;
      }
    }

    return false;
  }

  private static boolean hasSubarrayOfSizeKWithGivenSumByOptimal(int[] nums, int k, int target) {
    int n = nums.length;
    int currentSum = 0;
    for (int i = 0; i < k; i++) {
      currentSum += nums[i];
    }
    if (currentSum == target) {
      return true;
    }
    for (int j = k; j < n; j++) {
      currentSum = currentSum + nums[j] - nums[j - k];
      if (currentSum == target) {
        return true;
      }
    }

    return false;
  }

  static void main() {
    int[] nums = {1, 4, 2, 10, 2, 3, 1, 0, 20};
    int k = 3;
    int target = 6;
    System.out.println(hasSubarrayOfSizeKWithGivenSumByBF(nums, k, target));
    System.out.println(hasSubarrayOfSizeKWithGivenSumByOptimal(nums, k, target));
  }
}
