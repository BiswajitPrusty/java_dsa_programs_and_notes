package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class DsDay1Problems {

    /**
     * 1. Given an integer array nums, return true if any value appears at least twice in the array,
     * and return false if every element is distinct.
     * <p>
     * 2. Given an integer array nums, find the subarray which has the largest sum and return its sum.
     * Length of the max subarray
     * Elements of the max subarray
     * Start and End index of max subarray
     */
    public static void main(String[] args) {

        System.out.println(containsDuplicate1(new int[]{1, 2, 1, 3, 4, 5}));
        System.out.println(maxSubArray(new int[]{-1}));
    }

    public static boolean containsDuplicate1(int... num) {
        Set<Integer> nums = new HashSet<>(num.length);
        for (int i = 0; i < num.length; i++) {
            boolean duplicate = nums.add(num[i]);
            if (!duplicate)
                return true;
        }
        return false;
    }

    public static int maxSubArray(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (max < sum) max = sum;
            if (sum < 0) sum = 0;
        }

        return max;
    }

    // Find the maximum possible sum in arr[]
    // such that arr[m] is part of it
    static int maxCrossingSum(int arr[], int l, int m,
                              int h) {
        // Include elements on left of mid.
        int sum = 0;
        int left_sum = Integer.MIN_VALUE;
        for (int i = m; i >= l; i--) {
            sum = sum + arr[i];
            if (sum > left_sum)
                left_sum = sum;
        }

        // Include elements on right of mid
        sum = 0;
        int right_sum = Integer.MIN_VALUE;
        for (int i = m; i <= h; i++) {
            sum = sum + arr[i];
            if (sum > right_sum)
                right_sum = sum;
        }

        // Return sum of elements on left
        // and right of mid
        // returning only left_sum + right_sum will fail for
        // [-2, 1]
        return Math.max(left_sum + right_sum - arr[m],
                Math.max(left_sum, right_sum));
    }

// A Divide and Conquer based Java
// program for maximum subarray sum
// problem

    // Returns sum of maximum sum subarray
    // in aa[l..h]
    static int maxSubArraySum(int arr[], int l, int h) {
        //Invalid Range: low is greater than high
        if (l > h)
            return Integer.MIN_VALUE;
        // Base Case: Only one element
        if (l == h)
            return arr[l];

        // Find middle point
        int m = (l + h) / 2;

		/* Return maximum of following three
		possible cases:
		a) Maximum subarray sum in left half
		b) Maximum subarray sum in right half
		c) Maximum subarray sum such that the
		subarray crosses the midpoint */
        return Math.max(
                Math.max(maxSubArraySum(arr, l, m - 1),
                        maxSubArraySum(arr, m + 1, h)),
                maxCrossingSum(arr, l, m, h));
    }

    /* Driver program to test maxSubArraySum */
    public static void main1(String[] args) {
        int arr[] = {2, 3, 4, 5, 7};
        int n = arr.length;
        int max_sum = maxSubArraySum(arr, 0, n - 1);

        System.out.println("Maximum contiguous sum is "
                + max_sum);
    }

    public boolean containsDuplicate(int... num) {
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length - 1; j++) {

                if (num[i] == num[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
// This code is contributed by Prerna Saini

