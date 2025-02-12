package dsa.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumK560 {



    public static int subarraySumNotEfficient(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        // Step 1: Compute the prefix sum array
        int[] prefixSum = new int[n + 1];

        // Fill the prefixSum array where prefixSum[i] represents sum of nums[0..i-1]
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        // Step 2: Iterate through all pairs (i, j) to check for subarrays with sum k
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (prefixSum[j] - prefixSum[i] == k) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, prefix = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            if (map.containsKey(prefix - k)) {
                count++;
            }
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,2,3}, 3));
    }
}
