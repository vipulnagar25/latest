package problemSolution.arrayp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
  public static List<List<Integer>> threeSum(int[] nums) {
    int target = 0;
    int n = nums.length;

    List<List<Integer>> result = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < n - 2; i++) {
      for (int j = i + 1; j < n - 1; j++) {
        for (int k = j + 1; k < n; k++) {

          int sum = nums[i] + nums[j] + nums[k];

          if (sum == target) {
            List<Integer> triplet = new ArrayList<>();
            triplet.add(nums[i]);
            triplet.add(nums[j]);
            triplet.add(nums[k]);

            result.add(triplet);
          }
        }
      }
    }

    return result;
  }

  public static List<List<Integer>> threeSumBySort(int[] nums) {
    int target = 0;
    int n = nums.length;
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    System.out.println(Arrays.toString(nums));
    for (int i = 0; i < n - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) continue;
      int start = i + 1;
      int end = n - 1;
      while (start < end) {

        int sum = nums[i] + nums[start] + nums[end];
        if (sum == target) {

          result.add(List.of(nums[i], nums[start], nums[end]));
          start++;
          end--;
        } else if (sum < target) {
          start++;
        } else {
          end--;
        }
      }
    }
    return result;
  }

  static void main() {
    int[] nums = {-1,0,1,2,-1,-4};
    System.out.println(threeSum(nums));
    System.out.println(threeSumBySort(nums));
  }
}
