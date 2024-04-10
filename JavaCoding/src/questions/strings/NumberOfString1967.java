package questions.strings;

public class NumberOfString1967 {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for (String pattern : patterns) {
            boolean contains = word.contains(pattern);
            if (contains) {
                count++;
            }
        }
        return count;
    }
}
