package questions.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindWordsContainingCharacter2942 {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].contains(Character.toString(x))) {
                index.add(i);
            }
        }
        return index;
    }
}
