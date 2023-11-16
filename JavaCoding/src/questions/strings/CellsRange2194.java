package questions.strings;

import java.util.ArrayList;
import java.util.List;

public class CellsRange2194 {
    public static void main(String[] args) {
        cellsInRange("K1:L2");
    }

    /*
    Input: s = "K1:L2"
    Output: ["K1","K2","L1","L2"]

    Input: s = "A1:F1"
    Output: ["A1","B1","C1","D1","E1","F1"]
     */
    public static List<String> cellsInRange(String s) {
        List<String> cells = new ArrayList<>();
        int start = Character.getNumericValue(s.charAt(1));
        int end = Character.getNumericValue(s.charAt(4));
        for (char c = s.charAt(0); c <= s.charAt(3); c++) {
            for (int i = start; i <= end; i++) {
                cells.add(c + "" + i);
            }

        }
        return cells;
    }
}
