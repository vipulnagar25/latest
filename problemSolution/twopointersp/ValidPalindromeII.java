package problemSolution.twopointersp;

public class ValidPalindromeII {
  public static boolean validPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;

    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        // Try removing one char (either left or right)
        return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
      }
      left++;
      right--;
    }

    return true;
  }

  private static boolean isPalindrome(String s, int left, int right) {
    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }

  static void main() {
    String str = "cbbcc";
    System.out.println(validPalindrome(str));
  }
}
