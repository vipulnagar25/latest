package problemSolution.slidingWindowp;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII219 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (Math.abs(map.get(nums[i]) - i) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;

    }

    static void main() {
        var result = containsNearbyDuplicate(new int[]{99,99}, 2);
        System.out.println(result);
    }
}
