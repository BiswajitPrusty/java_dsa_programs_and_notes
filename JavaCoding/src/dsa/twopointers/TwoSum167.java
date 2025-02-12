package dsa.twopointers;

import java.util.Arrays;

public class TwoSum167 {


    public static int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] == target) {
                return new int[]{i, j};
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            }
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 3, 4}, 6)));
    }
}
