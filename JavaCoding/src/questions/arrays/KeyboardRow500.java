package questions.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class KeyboardRow500 {


    static final String row1 = "qwertyuiop";
    static final String row2 = "asdfghjkl";
    static final String row3 = "zxcvbnm";

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findWords(new String[]{"a", "b"})));
    }

    /**
     * row1 = "qwertyuiop"
     * row2 = "asdfghjkl"
     * row3 = "zxcvbnm"
     * Input: words = ["Hello","Alaska","Dad","Peace"]
     * Output: ["Alaska","Dad"]
     */
    public static String[] findWords(String[] words) {
        List<String> wordsList = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            int row1Count = 0;
            int row2Count = 0;
            int row3Count = 0;
            int wordLength = words[i].length();
            for (int j = 0; j <= wordLength - 1; j++) {
                String c = words[i].toLowerCase().charAt(j) + "";
                if (row1.contains(c)) {
                    row1Count++;
                    continue;
                }
                if (row2.contains(c)) {
                    row2Count++;
                    continue;

                }
                if (row3.contains(c)) {
                    row3Count++;
                    continue;

                }

            }

            if (row1Count == wordLength) {
                wordsList.add(words[i]);
            }
            if (row2Count == wordLength) {
                wordsList.add(words[i]);
            }
            if (row3Count == wordLength) {
                wordsList.add(words[i]);
            }
        }
        String[] filteredWords = new String[wordsList.size()];
        filteredWords = wordsList.toArray(filteredWords);
        return filteredWords;

    }
}
