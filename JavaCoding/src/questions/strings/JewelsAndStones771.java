package questions.strings;

import java.util.HashMap;

public class JewelsAndStones771 {

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
    }

    public static int numJewelsInStones(String jewels, String stones) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < stones.length(); i++) {
            map.put(stones.charAt(i), map.getOrDefault(stones.charAt(i), 0) + 1);
        }
        int ans = 0;
        for (int i = 0; i < jewels.length(); i++) {
            ans += map.getOrDefault(jewels.charAt(i), 0);
        }
        return ans;
    }
}
