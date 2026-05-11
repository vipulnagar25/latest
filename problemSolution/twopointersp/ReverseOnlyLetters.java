package problemSolution.twopointersp;

public class ReverseOnlyLetters {
  public static String reverseOnlyLetters(String s) {

    int start = 0;
    int end = s.length() - 1;
    while (start < end) {
      if (Character.isLetter(s.charAt(start)) && Character.isLetter(s.charAt(end))) {
        char temp = s.charAt(start);

      }
    }
    return "sss";
  }

  static void main() {

    /*      Input: s = "a-bC-dEf-ghIj"
    Output: "j-Ih-gfE-dCba"
    Example c3:

    Input: s = "Test1ng-Leet=code-Q!"
    Output: "Qedo1ct-eeLg=ntse-T!"*/

    String str = "ab-cd";
    System.out.println(reverseOnlyLetters(str));
  }
}
