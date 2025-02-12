package dsa.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring76 {

    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";
        int[] res = new int[2];
        int resLen = Integer.MAX_VALUE, l = 0;
        Map<Character, Integer> tcount = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char curr : t.toCharArray()) {
            tcount.put(curr, tcount.getOrDefault(curr, 0) + 1);
        }

        int have = 0, need = tcount.size();
        for (int r = 0; r < s.length(); r++) {
            char currChar = s.charAt(r);
            window.put(currChar, window.getOrDefault(currChar, 0) + 1);
            if (tcount.containsKey(currChar) && window.get(currChar) == tcount.get(currChar)) {
                have++;
            }
            while (have == need) {
                if (r - l + 1 < resLen) {
                    res[0] = l;
                    res[1] = r;
                    resLen = r - l + 1;
                }
                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);
                if (tcount.containsKey(leftChar) && window.get(leftChar) < tcount.get(leftChar)) {
                    have--;
                }
                l++;
            }
        }
        return resLen != Integer.MAX_VALUE ? s.substring(res[0], res[1] + 1) : "";
    }
}
