package questions.strings;

public class RemoveOutermostParentheses1021 {

    public String removeOuterParentheses(String s) {
        int count = 0;
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (count != 0) {
                    result.append(c);
                }
                count++;
            } else {
                if (count != 1) {
                    result.append(c);
                }
                count--;
            }
        }

        return result.toString();

    }
}
