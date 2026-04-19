package problemSolution.stringp;

public class LengthOfLastWord58 {


    public static int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int count = 0;
        s = s.trim();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                count++;
            } else {
                break;
            }

        }
        return count;
    }

    static void main() {
        System.out.println(lengthOfLastWord("luffy is still joyboy"));
    }
}
