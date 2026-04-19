package problemSolution.arrayp;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray26 {
    public static int removeElement(int[] nums, int val) {
        int i = 0;

        for (final int num : nums) {
            if (num != val) {
                nums[i++] = num;
            }
        }
        System.out.println(Arrays.toString(nums));
        return i;

    }

    static void main() {
        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 2));
    }
}
