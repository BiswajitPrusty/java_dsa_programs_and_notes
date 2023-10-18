package questions.arrays;

import java.util.HashSet;
import java.util.Set;

public class ConsistentStrings1684 {

    public static void main(String[] args) {
        System.out.println(countConsistentStrings("ab", new String[]{"ad", "bd", "aaab", "baa", "badab"}));
    }

    public static int countConsistentStrings(String allowed, String[] words) {
        Set<Character> allowedChars = new HashSet<>();
        for (int i = 0; i < allowed.length(); i++) {
            allowedChars.add(allowed.charAt(i));
        }
        int count = 0;
        for (String word : words) {
            int countChar = 0;
            for (int i = 0; i < word.length(); i++) {
                if (allowedChars.contains(word.charAt(i))) {
                    countChar++;
                }
            }
            if (countChar == word.length()) {
                count++;
            }

        }
        return count;
    }
}
