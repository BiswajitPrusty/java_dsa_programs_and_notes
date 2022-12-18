package LeetCode;

import java.util.HashMap;

public class EasyQuestions {

    public static void main(String[] args) {
        EasyQuestions e = new EasyQuestions();
//        e.romanToInt("MCMXCIV");
//        e.reverseString(new char[]{'h', 'e', 'l'});
//        e.singleNumber(new int[]{'h', 'h', 'l'});
    }

    public int singleNumber(int[] nums) {

        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            Integer counter = count.get(nums[i]);
            if (counter != null && counter == 2) {
                count.remove(nums[i]);
            }
        }
        Object o = count.keySet().toArray()[0];
        return (Integer) o;
    }

    public int maxDepth(TreeNode root) {
        // base case: if the root is null, the maximum depth is 0
        if (root == null) {
            return 0;
        }

        // compute the maximum depth of the left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // return the maximum of the two depths, plus 1 for the current node
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public void reverseString(char[] s) {

        int i = 0, j = s.length - 1;
        while (i <= j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public int romanToInt(String s) {
        int ans = 0;
        HashMap<Character, Integer> romanToInt = new HashMap<>();
        romanToInt.put('I', 1);
        romanToInt.put('V', 5);
        romanToInt.put('X', 10);
        romanToInt.put('L', 50);
        romanToInt.put('C', 100);
        romanToInt.put('D', 500);
        romanToInt.put('M', 1000);


        int nums[] = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            nums[i] = romanToInt.get(s.charAt(i));
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                ans -= nums[i];
            } else
                ans += nums[i];
        }
        return ans + nums[nums.length - 1];
    }
}
