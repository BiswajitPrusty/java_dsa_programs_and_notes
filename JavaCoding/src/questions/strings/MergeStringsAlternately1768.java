package questions.strings;

public class MergeStringsAlternately1768 {
    public static void main(String[] args) {
        System.out.println(mergeAlternately("ab", "pqrs"));
    }
    public static String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        char[] merge = new char[len1 + len2];
        if (len1 < len2) {
        }

        return null;
    }
    public static String mergeAlternately1(String word1, String word2) {
        char[] merge = new char[word1.length() + word2.length()];
        int index = 0;
        for(int i = 0; i < word1.length(); i++){
            merge[index] = word1.charAt(i);
            index += 2;
        }

        index = 1;
        for(int i = 0; i < word2.length(); i++){
            merge[index] = word2.charAt(i);
            index += 2;
        }
        return new String(merge);
    }

}
