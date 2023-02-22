package questions.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MergeTwoArraysBySummingValues6362 {
    Map<Integer, Integer> map = new HashMap<>();
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        loadIntoMap(nums1);
        loadIntoMap(nums2);
        int[][] ans = new int[map.size()][2];

        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans[i][0] = entry.getKey();
            ans[i][1] = entry.getValue();
            i++;
        }
        Arrays.sort(ans, Comparator.comparingInt(o -> o[0]));
        return ans;
    }

    public void loadIntoMap(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i][0], map.getOrDefault(nums[i][0], 0) + nums[i][1]);
        }
    }
}
