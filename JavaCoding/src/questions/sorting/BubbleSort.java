package questions.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        bubbleSort(new int[]{3, 5, 1, 2, 7, 9, 6});
    }

    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
