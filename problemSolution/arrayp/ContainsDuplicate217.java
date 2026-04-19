package problemSolution.arrayp;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate217 {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.add(nums[i]) == false) {
                return true;
            }

        }

        return false;
    }

    static void main() {
        System.out.println(containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));

    }
}
