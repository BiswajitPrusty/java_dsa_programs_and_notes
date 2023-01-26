package questions.maths;

import java.util.Arrays;

public class MinimumSumofFourDigitNumberAfterSplittingDigits2160 {

    public static void main(String[] args) {
        System.out.println(minimumSum(4009));
    }

    public static int minimumSum(int num) {
        int nums[] = new int[4];
        int i = 0;
        while (num > 0) {
            nums[i++] = num % 10;
            num /= 10;
        }
        Arrays.sort(nums);
        return (nums[0] * 10 + nums[3]) + (nums[1] * 10 + nums[2]);
    }
}
