package questions.arrays;

import java.util.Arrays;

public class RotateArray189 {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(rotate(3, 1, 2, 3, 4, 5, 6, 7)));
    }

    public void rotate2(int k, int... nums) {
        int length = nums.length;
        if (nums == null || length < 2) {
            return;
        }
        k = k % length;
        reverse(0, length - 1 - k, nums);
        reverse(length - k, length - 1, nums);
        reverse(0, length - 1, nums);

    }

    public static int[] rotate(int k, int... nums) {

        int length = nums.length;
        int index = 0;

        int[] arr = new int[length];

        for (int i = k; i < length; i++) {
            arr[i] = nums[index++];
        }

        index = 0;
        for (int i = length - k; i < length; i++) {
            arr[index++] = nums[i];
        }

        for (int i = 0; i < length; i++) {
            nums[i] = arr[i];
        }

        return nums;
    }

    public void reverse(int start, int end, int... nums) {
        int temp = 0;
        while (start < end) {
            temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

}
