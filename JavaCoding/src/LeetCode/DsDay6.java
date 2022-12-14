package LeetCode;

import java.util.HashMap;

public class DsDay6 {

    public static void main(String[] args) {

        DsDay6 d = new DsDay6();

        d.firstUniqChar("abccc");
        d.canConstruct("aa", "ab");
        d.isAnagram2("car", "rat");
    }

    public boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()) return false;

        // create freq array with size 26 as we have 26 lowercase English characters
        int[] freq = new int[26];

        // increase the frequency of each character in String s
        // decrease the frequency of each character in String t
        for(int i = 0;  i < s.length();  i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            freq[ch1 - 'a']++;
            freq[ch2-'a']--;
        }
        /* check all values in freq[], if all values in the freq[] is 0,
        means both Strings have same frequency of same characters, then return true,
        else return false */
        for(int i = 0; i< 26; i++){
            if(freq[i] != 0) return false;
        }
        return true;
    }

    /**
     * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
     *
     * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
     *
     * Example 1:
     *
     * Input: s = "anagram", t = "nagaram"
     * Output: true
     */
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> charRepeat = new HashMap<>();

        for (char c : t.toCharArray()) {
            charRepeat.put(c, charRepeat.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (charRepeat.containsKey(s.charAt(i))) {
                int check = charRepeat.put(s.charAt(i), charRepeat.get(s.charAt(i)) - 1) - 1;
                if (check == 0) {
                    charRepeat.remove(s.charAt(i));
                }
            }
        }
        return charRepeat.size() == 0 ? true : false;

    }
    /**
     * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
     * Example 1:
     * Input: s = "leetcode"
     * Output: 0
     */
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> allChars = new HashMap<>();

        for (char c : s.toCharArray()) {
            allChars.put(c, allChars.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (allChars.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
     * Each letter in magazine can only be used once in ransomNote.
     * Example 1:
     * Input: ransomNote = "aab", magazine = "baa"
     * Output: true
     */

    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character, Integer> ransom = new HashMap<>();

        for (char c : ransomNote.toCharArray()) {
            ransom.put(c, ransom.getOrDefault(c, 0) + 1);
        }

        for (char c : magazine.toCharArray()) {
            if (ransom.containsKey(c)) {
                Integer check = ransom.put(c, ransom.get(c) - 1) - 1;
                if (check == 0) {
                    ransom.remove(c);
                }
            }
        }


        return ransom.size() == 0 ? true : false;
    }
}
