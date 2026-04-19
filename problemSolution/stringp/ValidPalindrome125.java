package problemSolution.stringp;

public class ValidPalindrome125 {

    public static boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        String finalString = s.chars().filter(Character::isLetterOrDigit)
                .mapToObj(c -> (char) c)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString().toLowerCase();

        if (finalString.isEmpty()) {
            return true;
        }
        int start = 0;
        int end = finalString.length() - 1;
        while (start < end) {
            if (finalString.charAt(start) != finalString.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }


        return true;
    }

    static void main() {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

}
