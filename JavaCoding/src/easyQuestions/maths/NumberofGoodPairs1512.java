package easyQuestions.maths;

import java.util.HashMap;

public class NumberofGoodPairs1512 {

    public static void main(String[] abc) {
        System.out.println(numIdenticalPairs2(new int[]{1, 2, 3, 1, 1, 3}));
    }

    public static int numIdenticalPairs2(int[] nums) {
        int countGoodPairs = 0;
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        for (int i : nums) {
            int count = numsMap.getOrDefault(i, 0);
            countGoodPairs += count;
            numsMap.put(i, ++count);
        }
        return countGoodPairs;
    }


    public static int numIdenticalPairs(int[] nums) {
        int countGoodPairs = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] == nums[j])
                    countGoodPairs++;
            }
        }
        return countGoodPairs;
    }
}
