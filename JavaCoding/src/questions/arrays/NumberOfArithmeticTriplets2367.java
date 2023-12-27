package questions.arrays;

import java.util.HashSet;

public class NumberOfArithmeticTriplets2367 {

    /*
    Input: nums = [0,1,4,6,7,10], diff = 3
    Output: 2
    Explanation:
    i < j < k,
    nums[j] - nums[i] == diff, and
    nums[k] - nums[j] == diff.
    (1, 2, 4) is an arithmetic triplet because both 7 - 4 == 3 and 4 - 1 == 3.
    (2, 4, 5) is an arithmetic triplet because both 10 - 7 == 3 and 7 - 4 == 3.
     */

    public int arithmeticTriplets(int[] nums, int diff) {
        if(nums.length < 3) return 0;
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(set.contains(num - diff) && set.contains(num - diff*2)) {
                count++;
            }
            set.add(num);
        }
        return count;
    }
}
