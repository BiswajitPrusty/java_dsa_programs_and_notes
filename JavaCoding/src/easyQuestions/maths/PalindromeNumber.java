package easyQuestions.maths;

public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(1211));
    }
    public static boolean isPalindrome(int num) {
        int temp = num, rev = 0;

        while (temp > 0) {
            int ld = temp % 10;
            rev = rev * 10 + ld;
            temp /= 10;
        }
        return rev == num;
    }
}
