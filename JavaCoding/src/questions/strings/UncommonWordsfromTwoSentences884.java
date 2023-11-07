package questions.strings;

import java.util.*;

public class UncommonWordsfromTwoSentences884 {

    public static void main(String[] args) {
        String[] strings = uncommonFromSentences("this apple is sweet", "this apple is sour");
        System.out.println(Arrays.toString(strings));

    }

    /**
     * Input: s1 = "this apple is sweet", s2 = "this apple is sour"
     * Output: ["sweet","sour"]
     */
    public static String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> countOfAllWords = new HashMap<>();
        ArrayList<String> uncommonWords = new ArrayList<>();
        String combinedSentences = s1 + " " + s2;
        for (String s : combinedSentences.split(" ")) {
            countOfAllWords.put(s, countOfAllWords.getOrDefault(s, 0) + 1);
        }
        for (Map.Entry<String, Integer> e : countOfAllWords.entrySet()) {
            if (e.getValue() == 1)
                uncommonWords.add(e.getKey());
        }
        return Arrays.copyOf(uncommonWords.toArray(), uncommonWords.size(), String[].class);
    }
}
