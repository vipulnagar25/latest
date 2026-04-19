package problemSolution.stackp;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.empty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }

        }
         StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        System.out.println(sb.toString());
        return sb.toString();
    }

    static void main() {
        String s = "abbaca";//baca
        System.out.println(removeDuplicates(s));
    }
}
