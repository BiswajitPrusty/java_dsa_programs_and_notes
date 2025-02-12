package dsa.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        if (nums == null || nums.length < 3) return answer;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {

            if (nums[i - 1] == nums[i]) continue;

            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];

                if (sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                } else {
                    answer.add(List.of(nums[i], nums[l], nums[r]));

                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (r > l && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
