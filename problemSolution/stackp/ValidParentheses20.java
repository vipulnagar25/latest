package problemSolution.stackp;

import java.util.Stack;

public class ValidParentheses20 {

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' && !stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == ']' && !stack.empty() && stack.peek() == '[') {
                stack.pop();
            } else if (c == '}' && !stack.empty() && stack.peek() == '{') {
                stack.pop();
            } else {
                // Mismatch or stack is empty when encountering closing bracket
                return false;
            }
        }

        return stack.empty(); // true if all brackets matched
    }

    static void main() {

    }

}
