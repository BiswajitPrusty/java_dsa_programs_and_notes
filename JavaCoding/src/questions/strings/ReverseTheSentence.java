package questions.strings;

public class ReverseTheSentence {

    public static void main(String[] args) {
        reverseWord("the sky is blue".toCharArray());
    }

    public static void reverseWord(char[] s) {
        int start = 0;
        for (int end = 0; end < s.length; end++) {
            if (s[end] == ' ') {
                reverse(s, start, end - 1);
                start = end + 1;
            }
        }
        reverse(s, start, s.length - 1);
        reverse(s, 0, s.length - 1);
        System.out.println(new String(s));
    }
    public static void reverse(char[] c, int start, int end) {
        while (start <= end) {
            char temp = c[start];
            c[start] = c[end];
            c[end] = temp;
            start++;
            end--;
        }
    }

    public static void reverseSentence(String s) {
        String ans = "";
        String sentence = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sentence = ans + " " + sentence;
                ans = "";
                continue;
            }
            ans += s.charAt(i);
        }
        sentence = ans + " " + sentence;
        System.out.println(sentence);
    }
}
