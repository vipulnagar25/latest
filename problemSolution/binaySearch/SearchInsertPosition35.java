package problemSolution.binaySearch;

public class SearchInsertPosition35 {
    public static int searchInsert(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            System.out.println("mid" + ".[" + mid + "]" + "::::" + nums[mid]);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {

                low = mid + 1;
            }
        }
        System.out.println(high);
        return low;
    }

    static void main() {
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        var result = searchInsert(nums, target);
        System.out.println(result);

    }
}
