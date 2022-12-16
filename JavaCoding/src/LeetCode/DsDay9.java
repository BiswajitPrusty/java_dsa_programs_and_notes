package LeetCode;

import java.util.Stack;

public class DsDay9 {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        int size = stack.size();
        for (int i = 0; i < s.length(); i++) {

            switch (s.charAt(i)) {
                case '(':
                    stack.push('(');
                    break;
                case ')': {
                    if (size == 0 || stack.pop() != '(') {
                        return false;
                    }
                    break;
                }
                case '{':
                    stack.push('{');
                    break;
                case '}': {
                    if (size == 0 || stack.pop() != '{') {
                        return false;
                    }
                    break;
                }
                case '[':
                    stack.push('[');
                    break;
                case ']': {
                    if (size == 0 || stack.pop() != '[') {
                        return false;
                    }
                    break;
                }
            }

        }
        return size == 0;
    }
}

