package questions.strings;

public class ReverseVowelsOfString345 {

    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
    }

    public static String reverseVowels(String str) {
        char[] c = str.toCharArray();
        int start = 0;
        int end = c.length - 1;
        while (start < end) {
            if (!isVowel(c[start])) {
                start++;
            }

            if (!isVowel(c[end])) {
                end--;
            }

            if (isVowel(c[start]) && isVowel(c[end])) {
                char temp = c[start];
                c[start] = c[end];
                c[end] = temp;
                start++;
                end--;
            }
        }

        return new String(c);
    }

    public static boolean isVowel(char c) {
        return "aeiouAeiou".contains(String.valueOf(c));
    }
}
