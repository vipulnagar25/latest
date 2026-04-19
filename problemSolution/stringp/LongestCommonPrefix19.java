package problemSolution.stringp;

public class LongestCommonPrefix19 {

    public static String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        int minLen = Integer.MAX_VALUE;
        for (String s : strs) {
            minLen = Math.min(minLen, s.length());
        }

        int i = 0;
        for (; i < minLen; i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                System.out.println(strs[j]);
                if (strs[j].charAt(i) != ch) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0].substring(0, i);
    }


    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    //  return prefix;

    static void main() {
//        Input: strs = ["flower","flow","flight"]//"dog", "racecar", "car"
//        Output: "fl"
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));

    }
}

