package questions.strings;

public class Palindrome {

    public static void main(String[] args) {

        System.out.println(palindromeUsingWhile("abccba"));
    }

    public static boolean palindrome(String s) {
        int length = s.length() - 1;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(length - i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean palindromeUsingWhile(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
