package dsa.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring3 {

    //Input: s = "pwwkew"
    //Output: 3
    public static int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, maxLength = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            char curr = s.charAt(right);
            if (!set.contains(curr)) {
                set.add(curr);
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            }else{
                set.remove(s.charAt(left));
                left++;
            }

        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
