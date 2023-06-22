package questions.hashing;

import java.util.HashMap;
import java.util.Map;

public class DecodeTheMessage2325 {


    public static void main(String[] args) {
        decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv");
    }
    public static String decodeMessage(String key, String message) {

        Map<Character, Character> keyValues = new HashMap<>();
        char alphabet = 'a';
        for(int i = 0; i < key.length(); i++){
            if(key.charAt(i) != ' ' && !keyValues.containsKey(key.charAt(i))){
                keyValues.put(key.charAt(i),alphabet++);
            }
        }
        char[] check = message.toCharArray();
        for(int i = 0; i < check.length; i++){
            if(check[i] != ' '){
                check[i] = keyValues.get(check[i]);
            }
        }
        return new String(check);
    }
}
