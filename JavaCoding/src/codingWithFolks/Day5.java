package codingWithFolks;

import java.util.Arrays;

public class Day5 {

    public int singleNumber(int[] nums) {
        int ans = 0;
        int a[] = Arrays.stream(nums).sorted().distinct().toArray();
        for (int i = 0; i < a.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {

                if (a[i] == nums[j]) {
                    count++;
                    if (count > 2) {
                        break;
                    }
                }

            }
            if (count == 1) {
                return a[i];
            }
        }
        return 0;
    }

    public int numIdenticalPairs(int[] nums) {

        int count =0 ;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }

            }
        }
        return count;
    }
}
