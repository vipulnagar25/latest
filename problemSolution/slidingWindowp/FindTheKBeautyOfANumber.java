package problemSolution.slidingWindowp;

public class FindTheKBeautyOfANumber {
    public static int divisorSubstrings(int num, int k) {
        String s = String.valueOf(num);
        int count = 0;
        for (int i = 0; i <= s.length() - k; i++) {
            String temp = s.substring(i, i + k);
            int val = Integer.parseInt(temp);
            if (val != 0 && num % val == 0) {
                count++;
            }
        }
        return count;
    }

    static void main() {
        int num = 240, k = 2;
        var result = divisorSubstrings(num, k);
        System.out.println(result);

    }
}
