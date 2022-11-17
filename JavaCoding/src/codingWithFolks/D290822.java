package codingWithFolks;

import java.util.HashMap;
import java.util.Map;

public class D290822 {
    /*
    Input: nums = [3,2,4], target = 6
    Output: [1,2]
     */

    public static void main(String[] args) {
        for (int i : twoSum(new int[]{3, 2, 4}, 6)) {
            System.out.print(i + ", ");

        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int expected = target - nums[i];
            if (!map.containsKey(expected))
                map.put(nums[i], i);
            else return new int[]{map.get(expected), i};
        }
        return new int[]{0, 0};
    }

    public int[] twoSum2(int[] nums, int target) {
//         Optimized using hashmap. Time complexity O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int expected = target - nums[i];
            if (!map.containsKey(expected))
                map.put(nums[i], i);
            else return new int[]{map.get(expected), i};
        }
        return new int[]{0, 0};
    }
}
