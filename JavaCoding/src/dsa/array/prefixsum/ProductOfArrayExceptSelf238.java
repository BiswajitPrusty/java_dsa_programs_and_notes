package dsa.array.prefixsum;

import java.util.Arrays;

public class ProductOfArrayExceptSelf238 {

    /*
    Steps to Solve the Problem
1️⃣ Initialize Variables

Create an output array of size nums.length.
Use two variables:
prefix → stores product of elements before index i.
postfix → stores product of elements after index i.
2️⃣ Compute Prefix Products (Left to Right)

Traverse the array from left to right.
Store the cumulative product of all previous elements at output[i].
Update prefix *= nums[i].
3️⃣ Compute Postfix Products (Right to Left)

Traverse the array from right to left.
Multiply each output[i] (which already has prefix product) with postfix.
Update postfix *= nums[i].
Final Output
After both prefix and postfix calculations, output[i] contains the product of all elements except nums[i].
Return output array.


     */
    //without using extra memory
    public static int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];

        int prefix = 1, postfix = 1;
        for (int i = 0; i < nums.length; i++) {
            output[i] = prefix;
            prefix *= nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            output[i] *= postfix;
            postfix *= nums[i];
        }

        return output;
    }

    //using extra memory
    public static int[] productExceptSelf2(int[] nums) {
        int length = nums.length;
        int[] prefix = new int[length];
        int[] postfix = new int[length];
        prefix[0] = nums[0];
        postfix[length - 1] = nums[length - 1];
        for (int i = 1; i < length; i++) {
            prefix[i] = nums[i] * prefix[i - 1];
            postfix[length - 1 - i] = nums[length - i - 1] * postfix[length - i];
        }
        for (int i = 0; i < nums.length; i++) {

            nums[i] = (i == 0 ? 1 : prefix[i - 1]) * (i == length - 1 ? 1 : postfix[i + 1]);
        }
        System.out.println(Arrays.toString(postfix));
        System.out.println(Arrays.toString(prefix));
        System.out.println(Arrays.toString(nums));
        return nums;
    }


    public static void main(String[] args) {
//        productExceptSelf(new int[]{1, 2, 3, 4});
    }
}
