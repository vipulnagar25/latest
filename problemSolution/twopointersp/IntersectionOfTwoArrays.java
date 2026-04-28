package problemSolution.twopointersp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    static void main(){
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);

        }
        for (int num : nums2) {
            if (set1.contains(num)) {
                result.add(num);
            }
        }
        int[] res = new int[result.size()];
        int index = 0;
        for (int num : result) {
            res[index++] = num;
        }
        return res;
    }
}
