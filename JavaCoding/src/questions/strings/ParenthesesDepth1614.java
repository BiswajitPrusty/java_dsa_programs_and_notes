package questions.strings;

import java.util.ArrayDeque;
import java.util.Stack;

public class ParenthesesDepth1614 {
    public static void main(String[] args) {
        System.out.println(maxDepth("(1)+((2))+(((3)))"));
    }
    public static int maxDepth(String s) {
        int depth = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                depth++;
            } else if (s.charAt(i) == ')') {
                max = Math.max(depth, max);
                depth--;
            }
        }
        return max;
    }
}
