package codingWithFolks;

import java.util.Arrays;

public class Day8 {


    public static void main(String[] args) {
        int a[] = {0, 1, 0, 3, 12};
        moveZeroes(a);
    }

    public static void moveZeroes(int[] nums) {

        /**
         * Input: nums = [0,1,0,3,12]
         * Output: [1,3,12,0,0]
         */
        int index = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
