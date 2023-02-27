package questions.strings;

import java.util.Arrays;

public class Anagram {

    public static void main(String[] args) {
        System.out.println(isAnagramNaive("listen", "silent"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        //size is 256 as I am considering capital and small alphabets.
        int count[] = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
            count[t.charAt(i)]--;
        }
        for (int i : count) {
            if (i != 0) return false;
        }
        return true;
    }

    public static boolean isAnagramNaive(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }


}
