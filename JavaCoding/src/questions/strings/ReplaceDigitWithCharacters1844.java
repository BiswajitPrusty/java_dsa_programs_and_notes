package questions.strings;

public class ReplaceDigitWithCharacters1844 {

    public static void main(String[] args) {
        replaceDigits("a1c1e1");
    }
    /*
    Input: s = "a1c1e1"
    Output: "abcdef"
    Explanation: The digits are replaced as follows:
    - s[1] -> shift('a',1) = 'b'
    - s[3] -> shift('c',1) = 'd'
    - s[5] -> shift('e',1) = 'f'
     */
    public static String replaceDigits(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                result.append(s.charAt(i)); // Append letters as they are
            } else {
                char prevChar = s.charAt(i - 1);
                int shift = Character.getNumericValue(s.charAt(i));
                char newChar = shift(prevChar, shift);
                result.append(newChar); // Append the shifted character
            }
        }
        return result.toString();
    }

    public static char shift(char c, int x) {
        return (char) (c + x);
    }
}
