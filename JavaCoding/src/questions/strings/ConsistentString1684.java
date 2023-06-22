package questions.strings;

public class ConsistentString1684 {

    public static void main(String[] args) {
        countConsistentStrings("ab", new String[]{"ad","bd","aaab","baa","badab"});

    }

    public static int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        for(int i = 0; i < words.length; i++){

            for(int j = 0; j < allowed.length(); j++){
                if(words[i].contains(allowed.charAt(j)+"")){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
