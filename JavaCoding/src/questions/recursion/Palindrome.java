package questions.recursion;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(checkPalindrome("aaa", 0, 2));
    }

    public static boolean checkPalindrome(String s, int start, int end) {
        if (start >= end)
            return true;
        return s.charAt(start) == s.charAt(end) && checkPalindrome(s, start + 1, end - 1);
    }
}
