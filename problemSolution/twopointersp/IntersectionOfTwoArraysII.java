package problemSolution.twopointersp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {
  static void main() {
    int[] nums1 = {1, 2, 3, 2, 1, 5};
    int[] nums2 = {2, 9, 2};
    System.out.println(Arrays.toString(intersection(nums1, nums2)));
  }

  public static int[] intersection(int[] nums1, int[] nums2) {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> result = new ArrayList<>();

    // Count frequency of nums1
    for (int num : nums1) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    // Match with nums2
    for (int num : nums2) {
      if (map.getOrDefault(num, 0) > 0) {
        result.add(num);
        map.put(num, map.get(num) - 1);
      }
    }

    // Convert List to array
    int[] ans = new int[result.size()];
    for (int i = 0; i < result.size(); i++) {
      ans[i] = result.get(i);
    }

    return ans;
  }
}
