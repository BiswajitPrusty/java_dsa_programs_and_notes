package questions.hashing;

import java.util.*;
import java.util.stream.Collectors;

public class IsomorphicStrings205 {

    public static void main(String[] args) {
        isIsomorphic("egg", "add");
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> scount = new HashMap<>();
        Map<Character, Integer> tcount = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            scount.put(s.charAt(i), scount.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(int i = 0; i < t.length(); i++){
            tcount.put(t.charAt(i), tcount.getOrDefault(s.charAt(i), 0) + 1);
        }

        List<Integer> sValues = scount.values().stream().sorted().toList();
        List<Integer> tValues = tcount.values().stream().sorted().toList();

        if(sValues.size() == tValues.size()){
            for(int i = 0; i < sValues.size(); i++){
                if(sValues.get(i)!= tValues.get(i)) return false;
            }
        }else{
            return false;
        }

        return true;
    }
}
