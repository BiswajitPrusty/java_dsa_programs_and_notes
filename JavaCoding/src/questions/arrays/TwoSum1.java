package questions.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum2(new int[]{3,2,4}, 6)));
    }
    //for unsorted array to find the sum of two numbers
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if(map.containsKey(diff)) return new int[]{map.get(diff), i};
            map.put(nums[i], i);
        }

        return nums;
    }

    //arrays should be sorted then only we can apply two points approach.
    public static int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) return new int[]{i, j};
            else if (sum > target) j--;
            else i++;
        }
        return nums;
    }
}
