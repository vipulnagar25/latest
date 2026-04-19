package problemSolution.stringp;

public class ExcelSheetColumnTitle168 {
    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {
            // Adjust columnNumber to 0-indexed
            columnNumber--;
            int remainder = columnNumber % 26;
            char ch = (char) ('A' + remainder);
            sb.append(ch);
            // Move to the next digit
            columnNumber /= 26;
        }

        // Since we append in reverse order, reverse it at the end
        return sb.reverse().toString();
    }

    static void main() {
        System.out.println(convertToTitle(28));
    }
}
