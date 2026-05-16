package problemSolution.subarrayp;

public class SubarrayWithGivenProductExistsInAnArray {
  private static boolean hasSubarrayWithProductByBF(int[] nums, int k) {

    for (int i = 0; i < nums.length; i++) {
      int product = 1;

      for (int j = i; j < nums.length; j++) {

        product *= nums[j];

        if (product == k) {
          return true;
        }
      }
    }

    return false;
  }

  private static boolean hasSubarrayWithProductBy2Pointers(int[] nums, int k) {

    int left = 0;
    int product = 1;

    for (int right = 0; right < nums.length; right++) {

      product *= nums[right];

      while (left <= right && product > k) {
        product /= nums[left];
        left++;
      }

      if (product == k) {
        return true;
      }
    }

    return false;
  }

  static void main() {
    int[] nums = {10, 2, 4, 3, 6};
    int k = 6;
    System.out.println(hasSubarrayWithProductByBF(nums, k));
    System.out.println(hasSubarrayWithProductBy2Pointers(nums, k));
  }
}
