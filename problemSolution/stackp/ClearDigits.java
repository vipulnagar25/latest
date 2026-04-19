package problemSolution.stackp;

import java.util.Stack;

public class ClearDigits {
    public static String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.empty() && Character.isDigit(c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        System.out.println(stack);
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }

    static void main() {
        String string = "cb34";
        System.out.println(clearDigits(string));
    }
}
