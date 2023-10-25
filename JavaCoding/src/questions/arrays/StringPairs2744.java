package questions.arrays;

public class StringPairs2744 {

    public static void main(String[] args) {
        StringPairs2744 test = new StringPairs2744();
        System.out.println(test.maximumNumberOfStringPairs(new String[]{"ku", "dd", "gu", "uk"}));
    }

    public int maximumNumberOfStringPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i; j < words.length; j++) {
                if (j != i && words[i].equalsIgnoreCase(reverseString(words[j]))) {
                    count++;
                }
            }
        }
        return count;
    }
    public String reverseString(String word) {
        return new StringBuilder(word).reverse().toString();
    }
}
