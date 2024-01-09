package questions.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindCommonCharacters1002 {

    public static void main(String[] args) {
        FindCommonCharacters1002 f = new FindCommonCharacters1002();
        System.out.println(f.commonChars(new String[]{"bella", "label", "roller"}));
    }

    public List<String> commonChars(String[] words) {
        int[] countChars = count(words[0]);
        for (int i = 1; i < words.length; i++) {
            countChars = intersection(count(words[i]), countChars);
        }

        List<String> answer = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (countChars[i] != 0) {
                char a = 'a';
                a += i;
                String currentChar = String.valueOf(a);
                while (countChars[i] > 0) {
                    answer.add(currentChar);
                    countChars[i]--;
                }
            }
        }
        return answer;
    }

    public int[] intersection(int[] newWord, int[] oldWord) {
        int[] counter = new int[26];
        for (int i = 0; i < 26; i++) {
            counter[i] = Math.min(newWord[i], oldWord[i]);
        }
        return counter;
    }

    public int[] count(String word) {
        int[] counter = new int[26];
        for (char c : word.toCharArray()) {
            counter[c - 'a']++;
        }
        return counter;
    }

}
