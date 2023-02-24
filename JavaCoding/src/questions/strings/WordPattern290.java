package questions.strings;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordPattern290 {
    public static void main(String[] args) {
        second("abba", "dog cat cat dog");
    }

    public static boolean third(String pattern, String s) {
        HashMap<Character, String> hash = new HashMap<>();
        String split[] = s.split(" ");
        if (pattern.length() != split.length) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            char key = pattern.charAt(i);

            if(hash.containsKey(key) && !split[i].equals(hash.get(key)) ){
                return false;
            }

            if (!hash.containsKey(key) && hash.containsValue(split[i])) {
                return false;
            }
        }

        return true;
    }

    public static boolean second(String pattern, String s){
        HashMap<String, Character> hash = new HashMap<>();
        String[] splitWords = s.split(" ");
        char c = 'a';
        for(String i : Stream.of(splitWords).distinct().collect(Collectors.toList())){
            hash.put(i, c);
            c++;
        }
        int wordsLength = splitWords.length - 1;
        int patternLength = pattern.length() - 1;
        while(wordsLength >= 0 && patternLength >= 0){
            Character currentChar = hash.get(splitWords[wordsLength--]);
            if(currentChar == null || !currentChar.equals(pattern.charAt(patternLength--))){
                return false;
            }
        }
        return true;
    }

    public static boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> hash = new HashMap<>();
        List<String> arr = Stream.of(s.split(" ")).distinct().collect(Collectors.toList());
            char c = 'a';
        for (String i : arr) {
            hash.put(c, i);
            c++;
        }
        int p = pattern.length() - 1;
        int a = arr.size() - 1;
        while (p > 0 && a > 0) {
            String word = hash.get(pattern.charAt(p--));
            if (word == null || word.equals(arr.get(a--))) {
                return false;
            }
        }

        return true;
    }
}
