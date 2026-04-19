package problemSolution.stringmatchingp;

public class RotateString {
    static void main() {
        String s = "abcde", goal = "cdeab";
        System.out.println(rotateString(s, goal));
    }

    private static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            System.out.println("s.substring(i) ==="+  s.substring(i) +":::::"+"s.substring(0, i)===="+s.substring(0, i));
            String rotated = s.substring(i) + s.substring(0, i);
            System.out.println("final string ===="+ rotated);
            if (rotated.equals(goal)) return true;
        }
        return false;
    }

}
