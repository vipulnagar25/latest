package problemSolution.arrayp;

import java.util.Arrays;

public class MergedTwoSorted {
    public static void merge(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int i = 0;
        int j = 0;
        int k = 0;
        int[] result = new int[m + n];
        while (i < m && j < n) {
            if (nums1[i] == nums2[j]) {
                result[k++] = nums1[i];
                i++;
                j++;

            } else if (nums1[i] < nums2[j]) {
                result[k++] = nums1[i];
                i++;
            } else if (nums1[i] > nums2[j]) {
                result[k++] = nums2[j];
                j++;
            }

        }
        while (i < nums1.length) {
            result[k++] = nums1[i];
            i++;
        }
        while (j < nums2.length) {
            result[k++] = nums2[j];
            j++;
        }
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
        System.out.println(Arrays.toString(result));
    }

    static void main() {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {1, 6, 7, 8, 9};
        merge(array1, array2);
    }
}
