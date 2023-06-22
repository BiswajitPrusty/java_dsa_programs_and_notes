package questions.strings;

public class IsSubsequence392 {

    public static void main(String[] args) {
//        System.out.println(isSubsequenceUsingTwoPointer("abc", "ahbgdc"));
        System.out.println(recursiveSol("abc", "ahbgdc", 3, 6));
    }

    public static boolean recursiveSol(String s, String t, int is, int ts) {

        if (is == 0) return true;
        if (ts == 0) return false;
        if (s.charAt(is - 1) == t.charAt(ts - 1)) return recursiveSol(s, t, is - 1, ts - 1);
        else return recursiveSol(s, t, is, ts - 1);
    }

    public static boolean isSubsequenceUsingTwoPointer(String s, String t) {
        if (s.trim().isEmpty()) {
            return true;
        }
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == s.length();
    }

    //    my approach
    public static boolean isSubsequence(String s, String t) {
        if (s.trim().isEmpty()) {
            return true;
        }
        int index = t.indexOf(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int currentIndex = t.indexOf(s.charAt(i));
            if (index < currentIndex) {
                index = currentIndex;
            } else {
                return false;
            }
        }
        return index != -1;
    }
}
