package problemSolution.stringp;

public class PalindromeNumber9 {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x == 0) {
            return true;
        }
        int originalNumber = x;
        int reversedNumber = 0;
        while (originalNumber != 0) {
            int remainder = originalNumber % 10;
            originalNumber = originalNumber / 10;
            reversedNumber = reversedNumber * 10 + remainder;

        }
        if (x == reversedNumber) {
            return true;
        }
        return false;

    }


    static void main() {
        System.out.println(isPalindrome(121));

  /*      Input: x = 121
        Output: true
        Explanation: 121 reads as 121 from left to right and from right to left.*/

    }
}
