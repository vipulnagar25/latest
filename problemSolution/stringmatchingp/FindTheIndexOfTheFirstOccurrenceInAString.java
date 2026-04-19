package problemSolution.stringmatchingp;

public class FindTheIndexOfTheFirstOccurrenceInAString {
    public static int strStr(String haystack, String needle) {

        for (int i = 0; i <=haystack.length() - needle.length(); i++) {
            String subString = haystack.substring(i, i + needle.length());
            if (subString.equals(needle)) {
                return i;
            }

        }
        return -1;
    }

    static void main() {
        String haystack = "leetcode", needle = "leeto";
        System.out.println(strStr(haystack, needle));
    }
}
