package easyQuestions.strings;

public class LengthOfLastWord58 {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord3("a"));
    }

    public static int lengthOfLastWord3(String s) {
        int length = s.length() - 1;
        int countLastWord = 0;
        int trimSpaceCount = 0;
        while (length >= 0) {

            if (s.charAt(length) != ' ') {
                countLastWord++;
                trimSpaceCount = -1;
            } else if (s.charAt(length) == ' ' && trimSpaceCount == -1) {
                break;
            }
            length--;
        }
        return countLastWord;
    }

    public static int lengthOfLastWord2(String s) {
        s = s.trim();
        int findLastWord = s.length() - 1;
        int countLetters = 0;

        while (0 <= findLastWord && s.charAt(findLastWord) != ' ') {
            countLetters++;
            findLastWord--;
        }

        return countLetters++;
    }

    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        return words[words.length - 1].length();
    }
}
