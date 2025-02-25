package dsa.monotonicstack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement496 {

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {

        for (int i = 0; i < nums1.length; i++) {
            boolean found = false;
            int temp = nums1[i];
            for (int j = 0; j < nums2.length; j++) {
                if (found && temp < nums2[j]) {
                    nums1[i] = nums2[j];
                    break;
                }
                if (temp == nums2[j]) found = true;

            }
            if (nums1[i] == temp) {
                nums1[i] = -1;
            }

        }

        return nums1;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        Arrays.fill(nums1, -1);
        for (int i = 0; i < nums2.length; i++) {
            int cur = nums2[i];
            while (!stack.isEmpty() && cur > stack.peek()) {
                var pop = stack.pop();
                int val = map.get(pop);
                nums1[val] = cur;
            }
            if (map.containsKey(cur)) {
                stack.add(cur);
            }

        }

        return nums1;
    }

}
