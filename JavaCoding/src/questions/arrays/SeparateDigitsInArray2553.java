package questions.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.stream;

public class SeparateDigitsInArray2553 {

    public static void main(String[] args) {
        int[] ints = separateDigits(new int[]{13, 25, 83, 77});
        System.out.println(Arrays.toString(ints));
    }

    /**
     * Input: nums = [13,25,83,77]
     * Output: [1,3,2,5,8,3,7,7]
     */
    public static int[] separateDigits(int[] nums) {
        List<Integer> output = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            while (num > 0) {
                int lastDigit = num % 10;
                output.add(lastDigit);
                num /= 10;
            }
        }
        Collections.reverse(output);
        return output.stream().mapToInt(Integer::intValue).toArray();
    }
}
