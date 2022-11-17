package recursion;

public class PalindromRecursion {

	public static boolean isPalindrome(String input) {
		if (input.length() == 1 || input.length() == 0) {
			return true;
		}

		if (input.charAt(0) == input.charAt(input.length() - 1)) {
			return isPalindrome(input.substring(1, input.length() - 1));
		}

		return false;
	}
	public static void main(String[] args) {
		boolean a =isPalindrome("asdfghjkl;");
		System.out.println(a);
	}
}
