import java.util.Stack;

public class ParanthesisChecker {
    public static void main(String[] args) {
        String s = "{}}";
        System.out.println(isBalanced(s));
    }

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            }
            if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (stack.pop() != '(') {
                        return false;
                    }
                }
            }
            if (s.charAt(i) == '}') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (stack.pop() != '{') {
                        return false;
                    }
                }
            }
            if (s.charAt(i) == ']') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (stack.pop() != '[') {
                        return false;
                    }
                }
            }
        }

        return true;
    }

}
