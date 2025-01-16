package questions.arrays;

import java.util.*;

public class SlidingWindowQuestion {

    public static void main(String[] args) {
//        System.out.println(maximizeSum2(new int[]{1, 2, 3, 4, 5}, 3));
        System.out.println(Arrays.toString(findMaximumNum(new int[]{1,-1}, 1)));
        System.out.println(findAllAnagramsInaString438("cbaebabacd", "abc"));

    }


    public static int[] findMaximumNum(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        int[] ans = new int[nums.length - k + 1];
        int i = 0, j = 0;
        while (j < nums.length) {
            while (!q.isEmpty() && q.peekLast() < nums[j]) {
                q.removeLast();
            }
            q.add(nums[j]);
            if (j - i + 1 == k) {
                ans[i] = q.peek();
                if (nums[i] == q.peek()) {
                    q.pop();
                }
                i++;
            }
            j++;
        }
        return ans;
    }

    public static List<Integer> findAllAnagramsInaString438(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        int i = 0, j = 0, k = p.length();
        int count = map.size();
        while (j < s.length()) {
            char curr = s.charAt(j);
            if (map.containsKey(curr)) {
                map.put(curr, map.get(curr) - 1);
                if (map.get(curr) == 0) {
                    count--;
                }
            }
            if (j - i + 1 == k) {
                if (count == 0) {
                    ans.add(i);
                }
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    if (map.get(c) == 1) {
                        count++;
                    }
                }
                i++;
            }
            j++;

        }
        return ans;
    }

    public static void printNegativeNumber2(int[] nums, int k) {
        Queue<Integer> q = new LinkedList<>();
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] < 0)
                q.add(nums[j]);
            if (j - i + 1 == k) {
                if (q.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(q.peek());
                    if (q.peek() == nums[i]) {
                        q.poll();
                    }
                    i++;
                }
            }
            j++;
        }
    }

    public static void printNegativeNumber(int[] nums, int k) {
        for (int i = 0; i <= nums.length - k; i++) {
            for (int j = i; j < i + k; j++) {
                if (nums[j] < 0) {
                    System.out.println(nums[j]);
                    break;
                }
            }
        }
    }


    public static int maximizeSum2(int[] nums, int k) {
        int sum = 0, maxSum = 0, i = 0, j = 0;
        while (j < nums.length) {
            sum += nums[j];
            if (j - i + 1 == k) {
                maxSum = Math.max(sum, maxSum);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return maxSum;
    }


    public static int maximizeSum(int[] nums, int k) {
        int maxSum = 0;
        for (int i = 0; i + k - 1 < nums.length; i++) {
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum += nums[i + j];
            }
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

}
