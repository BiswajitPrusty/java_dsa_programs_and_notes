package codingWithFolks;

public class Day10 {

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
    }

    /**
     * Input: s = "axc", t = "ahbgdc"
     * Output: false
     * <p>
     * Input: s = "abc", t = "ahbgdc"
     * Output: true
     * "acb"
     * "ahbgdc"
     * output: false
     */
    public static boolean isSubsequence(String s, String t) {
        int i = 0;
        for (int j = 0; j < t.length() && i < s.length(); j++)
            if (t.charAt(j) == s.charAt(i)){
                i++;
            }
        return i == s.length();
    }

    public static boolean isSubsequence2(String s, String t) {

        if (s.equals(""))
            return true;
        if (t.equals(""))
            return false;
        char[] a = t.toCharArray();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    char temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
            break;

        }
        boolean isSub = false;
        for (int i = 0; i < s.length(); i++) {
            char check = s.charAt(i);
            String con = String.valueOf(check);
            if (check < a[a.length - 1] && t.contains(con)) {
                isSub = true;
            } else
                return false;

        }
        return isSub;
    }
}


