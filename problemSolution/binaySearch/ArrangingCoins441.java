package problemSolution.binaySearch;

public class ArrangingCoins441 {
    public static int arrangeCoins(int n) {
        long left = 0, right = n;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long coins = mid * (mid + 1) / 2;

            if (coins == n) {
                return (int) mid;
            }
            if (coins < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (int) right;
    }

    static void main() {
        System.out.println(arrangeCoins(5));

    }
}
