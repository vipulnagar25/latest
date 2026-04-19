package problemSolution.binaySearch;

public class FindMinimumInRotatedSortedArray {
    public  static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
                } else {
                end = mid-1;
            }
        }
        return nums[start];
    }
    static void main() {
        int[] nums = {3,4,5,1,2};
        System.out.println(findMin(nums));

    }
}
