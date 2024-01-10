package questions.sorting;

public class MaximumProductDifference1913 {

    public int maxProductDifference(int[] nums) {
        int max1 = 0,
                max2 = 0,
                min1 = Integer.MAX_VALUE,
                min2 = Integer.MAX_VALUE,
                index1 = 0,
                index2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max1 < nums[i]) {
                max1 = nums[i];
                index1 = i;
            }
            if (min1 > nums[i]) {
                min1 = nums[i];
                index2 = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (index1 != i)
                max2 = Math.max(max2, nums[i]);
            if (index2 != i)
                min2 = Math.min(min2, nums[i]);
        }
        return (max1 * max2) - (min1 * min2);
    }
}
