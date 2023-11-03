package questions.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SumOfUniqueElements {

    public static void main(String[] args) {
        System.out.println(sumOfUnique(new int[]{1, 2, 3, 2}));
    }

    public static int sumOfUnique(int[] nums) {

        Map<Integer, Integer> uniqueNums = new HashMap<>();
        int answer = 0;

        for (int num : nums) {
            uniqueNums.put(num, uniqueNums.getOrDefault(num, 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = uniqueNums.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() == 1) {
                answer += entry.getKey();
            }
        }
        return answer;
    }
}
