package questions.strings;

public class ReverseTheSentence {

    public static void main(String[] args) {
        reverseSentence("the sky is blue");
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
