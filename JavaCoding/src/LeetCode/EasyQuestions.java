package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EasyQuestions {

    public static void main(String[] args) {
        EasyQuestions e = new EasyQuestions();
//        e.romanToInt("MCMXCIV");
//        e.reverseString(new char[]{'h', 'e', 'l'});
//        e.singleNumber(new int[]{'h', 'h', 'l'});
        System.out.println(e.fizzBuzz(3));
    }

    /**
     * Given an integer n, return a string array answer (1-indexed) where:
     * answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
     * answer[i] == "Fizz" if i is divisible by 3.
     * answer[i] == "Buzz" if i is divisible by 5.
     * answer[i] == i (as a string) if none of the above conditions are true.
     * Example 1:
     * Input: n = 3
     * Output: ["1","2","Fizz"]
     */
    public List<String> fizzBuzz(int n) {

        List<String> answer = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                answer.add("FizzBuzz");
            } else if (i % 3 == 0) {
                answer.add("Fizz");
            } else if (i % 5 == 0) {
                answer.add("Buzz");
            } else {
                answer.add(i + "");
            }
        }
        return answer;
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        return insertToBst(nums, 0, nums.length - 1);
    }

    public TreeNode insertToBst(int[] nums, int l, int r) {

        if (l > r) {
            return null;
        }
        //choose the middle element and
        int mid = l + (r - l) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = insertToBst(nums, l, mid - 1);
        node.right = insertToBst(nums, mid + 1, r);
        return node;

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
