package problemSolution.arrayp;

public class SingleNumber136 {
    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (final int num : nums) {
            ans = ans ^ num;
        }
        return ans;

    }

    static void main() {
        var singleNumber = singleNumber(new int[]{4, 1, 2, 1, 2});
        System.out.println(singleNumber);
    }
}
