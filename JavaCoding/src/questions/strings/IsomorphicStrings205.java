package questions.strings;

import java.util.HashMap;

public class IsomorphicStrings205 {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> keyValues = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            boolean checkKey = keyValues.containsKey(s.charAt(i));
            if (checkKey) {
                boolean isIso = keyValues.get(s.charAt(i)) == t.charAt(i);
                if (!isIso) {
                    return false;
                }
            } else {
                boolean checkValue = keyValues.containsValue(t.charAt(i));
                if (checkValue) {
                    return false;
                }
                keyValues.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}
