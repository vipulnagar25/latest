package problemSolution.twopointersp;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
  public static void removeDuplicates(int[] nums) {
    int prev = nums[0];
    StringBuilder res = new StringBuilder(prev + ",");
    for (int j = 1; j < nums.length; j++) {
      if (prev != nums[j]) {
        res.append(nums[j]).append(",");
        prev = nums[j];
      }
    }
    System.out.println(res);
  }

  public static void removeDuplicates(int[] nums, int minFrequency) {
    int index = minFrequency;
    StringBuilder res = new StringBuilder();
    for (int j = 0; j < minFrequency; j++) {
      res.append(nums[j]).append(",");
    }
    for (int i = minFrequency; i < nums.length; i++) {
      if (nums[i] != nums[index - minFrequency]) {
        res.append(nums[i]).append(",");
        nums[index++] = nums[i];
      }
    }
    System.out.println(index);
    System.out.println(Arrays.toString(nums));
    System.out.println(res);
  }

  static void main() {
    int[] arr = {
      1, 2, 2, 2, 3, 4, 4, 4,
    };
    // removeDuplicates(arr);
    removeDuplicates(arr, 2);
  }
}
