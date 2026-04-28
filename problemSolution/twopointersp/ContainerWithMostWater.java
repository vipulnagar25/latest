package problemSolution.twopointersp;

public class ContainerWithMostWater {
  public static int maxArea(int[] height) {
    int start = 0;
    int end = height.length - 1;
    int res = 0;
    while (start < end) {

      int waterArea = Math.min(height[start], height[end]) * (end - start);
      res = Math.max(res, waterArea);
      if (height[start] < height[end]) {
        start++;
      } else {
        end--;
      }
    }

    return res;
  }

  static void main() {
    int[] nums1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    System.out.println(maxArea(nums1));
  }
}
