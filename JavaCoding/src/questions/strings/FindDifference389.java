package questions.strings;

public class FindDifference389 {

    public static void main(String[] args) {
        System.out.println(findTheDifference("a", "aa"));
    }

    public static char findTheDifference(String s, String t) {
        int xor = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            xor = s.charAt(i) ^ xor;
            xor = t.charAt(i) ^ xor;
        }
        return (char) xor;
    }

}
