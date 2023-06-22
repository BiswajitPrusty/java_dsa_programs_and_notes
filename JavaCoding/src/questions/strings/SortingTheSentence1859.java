package questions.strings;

public class SortingTheSentence1859 {

    public static void main(String[] args) {
        System.out.println(sortSentence("is2 sentence4 This1 a3"));
    }

    /*
    Input: s = "is2 sentence4 This1 a3"
    Output: "This is a sentence"
    Explanation: Sort the words in s to their original positions "This1 is2 a3 sentence4", then remove the numbers.
     */
    public static String sortSentence(String s) {
        String[] words = s.split(" ");
        String[] result = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            char indexChar = words[i].charAt(words[i].length() - 1);
            int index = Integer.valueOf(String.valueOf(indexChar));
            result[index - 1] = words[i].substring(0, words[i].length() - 1);
        }
        return String.join(" ", result);
    }
}
