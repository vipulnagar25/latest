package problemSolution.subarrayp;

public class MaximumProductSubarray {
  public static int maxProduct(int[] nums) {
    int n = nums.length;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      int product = 1;
      for (int j = i; j < n; j++) {
        product = product * nums[j];
        max = Math.max(product, max);
      }
    }

    return max;
  }

  public static int maxProductOptimal(int[] nums) {

    int n = nums.length;
    int max = nums[0];
    int min = nums[0];
    int ans = nums[0];
    for (int i = 1; i < n; i++) {
      int temp = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
      min = Math.min(nums[i], Math.min(min * nums[i], max * nums[i]));
      max = temp;
      ans = Math.max(ans, max);
    }

    return ans;
  }

  static void main() {
    int[] nums = {2, 3, -2, 4};
    System.out.println(maxProduct(nums));
    System.out.println(maxProductOptimal(nums));
    nums = new int[] {-2, 0, -1};
    System.out.println(maxProduct(nums));
    System.out.println(maxProductOptimal(nums));
  }
}
