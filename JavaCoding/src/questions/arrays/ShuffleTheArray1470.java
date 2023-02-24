package questions.arrays;

import java.util.Arrays;

public class ShuffleTheArray1470 {

    public static void main(String[] args) {
        shuffle2(new int[]{2, 5, 1, 3, 4, 7}, 3);
    }

    //efficient solution with in place solution
    public static int[] shuffle2(int[] nums, int n) {
        for (int i = n; i < nums.length; i++) {
            nums[i] = (nums[i] * 1024) + nums[i - n];
        }
        int index = 0;
        for (int i = n; i < nums.length; i++) {
            nums[index++] = nums[i] % 1024;
            nums[index++] = nums[i] / 1024;
        }
        System.out.println(Arrays.toString(nums));
        return nums;
    }

    //naive approach
    public int[] shuffle(int[] nums, int n) {
        int[] a = new int[nums.length];
        int j = 0;
        for (int i = 0; i < n; i++) {
            a[j++] = nums[i];
            a[j++] = nums[i + n];
        }
        return a;
    }
}
