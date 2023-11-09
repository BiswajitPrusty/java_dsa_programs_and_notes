package questions.strings;

import java.util.Arrays;

public class RotateString796 {

    public static void main(String[] args) {
        RotateString796 r = new RotateString796();
        System.out.println(r.rotateString("abcde", "abced"));
    }

    /**
     * Input: s = "abcde", goal = "cdeab"
     * Output: true
     */
    public boolean rotateString(String s, String goal) {
        char[] letters = s.toCharArray();
        char[] goalCharArray = goal.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            moveOneStep(letters);
            if (Arrays.equals(letters, goalCharArray)) {
                return true;
            }
        }

        return false;
    }

    public void moveOneStep(char[] letters) {
        char lastChar = letters[letters.length - 1];
        for (int i = 0; i < letters.length; i++) {
            char temp = letters[i];
            letters[i] = lastChar;
            lastChar = temp;
        }

    }
}
