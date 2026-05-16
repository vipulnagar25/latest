package problemSolution.subarrayp;

public class FindPivotIndex724 {
  public static int pivotIndex(int[] nums) {
    int totalSum = 0;
    for (int i = 0; i < nums.length; i++) {
      totalSum += nums[i];
    }
    int leftSum = 0;
    for (int i = 0; i < nums.length; i++) {
      int rightSum = totalSum - leftSum - nums[i];
      if (leftSum == rightSum) {
        return i;
      }

      leftSum = leftSum + nums[i];
    }

    return -1;
  }

  static void main() {
    int[] nums = {1, 7, 3, 6, 5, 6};
    System.out.println(pivotIndex(nums));
  }
}
