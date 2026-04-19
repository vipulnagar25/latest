package problemSolution.slidingWindowp;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters3 {


    private static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        int i = 0;
        for (; i < s.length(); i++) {
            int idx = map.getOrDefault(s.charAt(i), -1);
            if (idx != -1 && idx >= left) {
                int index = map.get(s.charAt(i));
                maxLength = Math.max(maxLength, i - left);
                left = index + 1;
            }
            map.put(s.charAt(i), i);

        }

        return Math.max(maxLength, i - left);
    }

    static void main() {
        String s = "abcabcbb";
        int result = lengthOfLongestSubstring(s);
        System.out.println(result);
    }


}
