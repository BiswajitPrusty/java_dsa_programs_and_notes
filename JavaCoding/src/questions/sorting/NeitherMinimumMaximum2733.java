package questions.sorting;

public class NeitherMinimumMaximum2733 {
    public static void main(String[] args) {
        System.out.println(findNonMinOrMax(new int[]{1,2,3}));
    }

    public static int findNonMinOrMax(int[] nums) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (max > nums[i] && nums[i] > min) {
                return nums[i];
            }
        }
        return -1;
    }
}
