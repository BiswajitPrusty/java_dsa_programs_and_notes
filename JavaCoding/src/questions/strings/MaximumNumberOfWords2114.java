package questions.strings;

public class MaximumNumberOfWords2114 {

    public int mostWordsFound(String[] sentences) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < sentences.length; i++) {
           ans = Math.max(sentences[i].split(" ").length, ans);
        }
        return ans;
    }
}
