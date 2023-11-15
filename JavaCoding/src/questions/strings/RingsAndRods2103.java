package questions.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RingsAndRods2103 {

    public static void main(String[] args) {
        System.out.println(countPoints("G4"));
    }
    public static int countPoints(String rings) {
        Map<Character, List<Character>> rods = new HashMap<>();
        for (int i = 0; i < rings.length() - 1; i +=2) {
            List<Character> characterList = rods.getOrDefault(rings.charAt(i + 1), new ArrayList<>());
            characterList.add(rings.charAt(i));
            rods.put(rings.charAt(i + 1), characterList);
        }
        int countAllColorRods = 0;
        for (List<Character> chars : rods.values()) {
            if (chars.contains('R') && chars.contains('G') && chars.contains('B')) {
                countAllColorRods++;
            }
        }
        return countAllColorRods;
    }
}
