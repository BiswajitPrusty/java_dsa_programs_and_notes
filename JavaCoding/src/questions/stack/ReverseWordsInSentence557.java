package questions.stack;

public class ReverseWordsInSentence557 {

    public static void main(String[] args) {
        ReverseWordsInSentence557 words = new ReverseWordsInSentence557();
        System.out.println(words.reverseWords("Let's take LeetCode contest"));
    }

    /*
    Input: s = "Let's take LeetCode contest"
    Output: "s'teL ekat edoCteeL tsetnoc"
    */
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = reverse(words[i]);
        }
        return String.join(" ", words);
    }

    private String reverse(String word) {
        char[] charArray = word.toCharArray();
        int start = 0, end = word.length() - 1;
        while (start <= end) {
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }
        return new String(charArray);
    }

}
