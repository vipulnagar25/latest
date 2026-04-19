package problemSolution.arrayp;

import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }


            map.put(nums[i], i);
        }
        return new int[0];
    }


    static void main() {


        //  Input: nums = [2,7,11,15], target = 9

        int[] result = twoSum(new int[]{3, 3}, 6);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}
