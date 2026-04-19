package problemSolution.slidingWindowp;

public class SubstringsOfSizeThreeWithDistinctCharacters1876 {
    public static int countGoodSubstrings(String s) {
        int window = 3;
        int count = 0;
        for (int i = 0; i <= s.length() - window; i++) {
            String temp = s.substring(i, i + window);

            if (temp.charAt(0) != temp.charAt(1) && temp.charAt(1) != temp.charAt(2) && temp.charAt(0) != temp.charAt(2)) {
                count++;
            }

        }


        return count;
    }

    static void main() {
        String s = "aababcabc";
        var result = countGoodSubstrings(s);
        System.out.println(result);

    }
}
