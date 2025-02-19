package dsa.dynamicprogramming;

import java.util.Arrays;

public class MaximumProductSubarray152 {
    public static int maxProduct(int[] nums) {
        int min = 1, max = 1, res = Arrays.stream(nums).max().getAsInt();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                min = 1;
                max = 1;
                continue;
            }
            int currMax = nums[i] * max;
            int currMin = nums[i] * min;
            max = Math.max(Math.max(currMax, currMin), nums[i]);
            min = Math.min(Math.min(currMax, currMin), nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-2,0,-1}));

    }
}
