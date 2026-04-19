package problemSolution.binaySearch;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;

    }

    static void main() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int target = 10;
        var result = binarySearch(arr, target);
        if (result > -1) {
            System.out.println(arr[result]);
        } else {
            System.out.println("not found");
        }

    }
}
