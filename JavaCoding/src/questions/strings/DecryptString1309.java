package questions.strings;

public class DecryptString1309 {

    public static void main(String[] args) {
        System.out.println(freqAlphabets("10#11#12"));
    }

    /**
     * Input: s = "10#11#12"
     * Output: "jkab"
     * Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
     */
    public static String freqAlphabets(String s) {
        char[] code = s.toCharArray();
        StringBuilder response = new StringBuilder();
        for (int i = code.length - 1; i >= 0; i--) {
            char letter = s.charAt(i);
            if (letter == '#') {
                int firstNumber = Character.getNumericValue(code[i - 1]);
                int secondNumber = Character.getNumericValue(code[i - 2]) * 10;
                int num = secondNumber + firstNumber;
                char c = (char) ('a' + num - 1);
                response.append(c);
                i -= 2;

            } else {
                int num = Character.getNumericValue(code[i]);
                char c = (char) ('a' + num - 1);
                response.append(c);
            }
        }
        return response.reverse().toString();
    }
}
