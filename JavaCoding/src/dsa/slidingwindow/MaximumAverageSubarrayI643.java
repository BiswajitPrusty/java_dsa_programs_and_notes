package dsa.slidingwindow;

public class MaximumAverageSubarrayI643 {

    public double findMaxAverage(int[] nums, int k) {
        if (nums.length == 1) return (double) nums[0];
        double maxSum = (double) Integer.MIN_VALUE, sum = 0;

        int i = 0, j = 0;

        while (j < nums.length) {
            sum += nums[j];
            if (j - i + 1 == k) {
                maxSum = Math.max(maxSum, sum);
                sum -= nums[i];
                i++;
            }

            j++;
        }
        return maxSum / k;
    }


}
