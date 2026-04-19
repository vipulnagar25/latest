package problemSolution.stringp;

public class AddBinary67 {
    public static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();

        while (i >= 0 || j >= 0 || carry == 1) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            result.append(sum % 2); // binary digit
            carry = sum / 2;        // carry
        }

        return result.reverse().toString();
    }

    static void main() {
        System.out.println(addBinary("1010", "1011"));
     /*  Input: a = "11", b = "1"
        Output: "100"
        Input: a = "1010", b = "1011"
        Output: "10101"

        */
    }
}
