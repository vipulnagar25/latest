package problemSolution.arrayp;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  public static int[] twoSumNativeApproach(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {

        if (nums[i] + nums[j] == target) {
          return new int[] {i, j};
        }
      }
    }
    return new int[0];
  }

  public static int[] twoSumByMap(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        return new int[] {map.get(complement), i};
      }

      map.put(nums[i], i);
    }
    return new int[0];
  }

  public static int[] twoSumBy2Pointer(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left < right) {
      int result = nums[left] + nums[right];
      if (result == target) {
        return new int[] {left, right};
      } else if (result > target) {
        right--;
      } else {
        left++;
      }
    }
    return new int[0];
  }

  static void main() {

    int[] result = twoSumByMap(new int[] {3, 3}, 6);
    System.out.println("[" + result[0] + ", " + result[1] + "]");
    int[] nums = {2, 7, 11, 15};
    int target = 9;
    int[] result1 = twoSumBy2Pointer(nums, target);
    System.out.println("[" + result1[0] + ", " + result1[1] + "]");
  }
}
