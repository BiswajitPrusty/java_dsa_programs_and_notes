package questions.strings;

public class FirstOccurrenceInString28 {

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issip"));
    }

    public static int strStr2(String haystack, String needle) {

        return -1;
    }

    public  static int strStr(String haystack, String needle) {
        int j = 0;
        for (int start = 0; start < haystack.length(); start++) {
            int subStringIndex = 0;
            j = start;
            while (j < haystack.length() && subStringIndex < needle.length()) {
                if (needle.charAt(subStringIndex) != haystack.charAt(j)) {
                    break;
                } else {
                    subStringIndex++;
                    j++;
                }
            }
            if (needle.length() == subStringIndex ) {
                return start;
            }
        }

        return -1;
    }
}
