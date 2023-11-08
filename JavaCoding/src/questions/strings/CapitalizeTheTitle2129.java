package questions.strings;

public class CapitalizeTheTitle2129 {

    public static void main(String[] args) {
        System.out.println(capitalizeTitle("i lOve leetcode"));
    }
    public static String capitalizeTitle(String title) {
        String[] words = title.toLowerCase().split(" ");

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 2) {
                words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
            }
        }
        return String.join(" ", words);
    }
}
