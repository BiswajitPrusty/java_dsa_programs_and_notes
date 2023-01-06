package arrays;

import java.util.HashMap;

public class AllEasy {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> list = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (list.containsKey(diff)) {
                return new int[]{list.get(diff), i};
            }
            list.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}
