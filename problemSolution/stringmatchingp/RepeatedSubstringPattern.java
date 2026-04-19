package problemSolution.stringmatchingp;

import java.util.HashSet;
import java.util.Set;

public class RepeatedSubstringPattern {
    public static boolean repeatedSubstringPattern(String s) {
        StringBuilder sb = new StringBuilder();
        if (s.length() <= 1) {
            return false;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.add(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }
        if(sb.length() == s.length()){
            return true;
        }
        if(s.length() % sb.length() != 0){
            return false;
        }
        int j = sb.length();
        for (; j < s.length(); j = j + sb.length()) {
            String subString = s.substring(j, j + sb.length());
            if (!subString.contentEquals(sb)) {
                return false;
            }
        }

        return true;
    }

    static void main() {
        String s = "abaababaab";
        System.out.println(repeatedSubstringPattern(s));
    }
}
