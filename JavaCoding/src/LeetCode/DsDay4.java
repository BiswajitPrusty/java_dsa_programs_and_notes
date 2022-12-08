package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class DsDay4 {

    public static void main(String[] args) {
        DsDay4 d = new DsDay4();
        System.out.println(d.generate(5));

    }

    /**
     * Input: numRows = 5
     * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
     */
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> currentArray = new ArrayList<>();
            if (result.size() != 0) {
                List<Integer> previousArray = result.get(i - 1);
                int sum = 0;
                for (int value : previousArray) {
                    sum += value;
                    currentArray.add(sum);
                    sum = value;
                }
                currentArray.add(1);

            } else {
                currentArray.add(1);
            }
            result.add(currentArray);
        }
        return result;
    }

}
