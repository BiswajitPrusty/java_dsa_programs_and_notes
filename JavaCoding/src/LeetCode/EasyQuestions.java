package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class EasyQuestions {

    public static void main(String[] args) {
        EasyQuestions e = new EasyQuestions();
//        e.romanToInt("MCMXCIV");
//        e.reverseString(new char[]{'h', 'e', 'l'});
//        e.singleNumber(new int[]{'h', 'h', 'l'});
//        System.out.println(e.fizzBuzz(3));
        e.majorityElement(new int[]{1, 2, 3, 3, 2, 2});
    }

    /*
    Input: nums = [3,0,1]
    Output: 2
    Explanation: n = 3 since there are 3 numbers,
    so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
     */
    public int missingNumber(int[] nums) {

        int sum = 0;
        for(int num: nums)
            sum += num;

        return (nums.length * (nums.length + 1) )/ 2 - sum;
    }

    /**
     * using Moore's voting algorithm
     * This can be solved by Moore's voting algorithm. Basic idea of the algorithm is if we cancel out each
     * occurrence of an element e with all the other elements that are different from e then e will exist till end
     * if it is a majority element. Below code loops through each element and maintains a count of the element that
     * has the potential of being the majority element. If next element is same then increments the count,
     * otherwise decrements the count. If the count reaches 0 then update the potential index to the current element and sets count to 1.
     */
    public int majorityElement(int[] num) {

        int majorityIndex = 0;
        for (int count = 1, i = 1; i < num.length; i++) {
            int i1 = num[majorityIndex] == num[i] ? count++ : count--;
            if (count == 0) {
                majorityIndex = i;
                count = 1;
            }
        }

        return num[majorityIndex];
    }

    /**
     * Input: n = 00000000000000000000000000001011
     * Output: 3
     * Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
     */
    /**
     * a	b	a & b
     * 0	0	0
     * 0	1	0
     * 1	0	0
     * 1	1	1
     * Let's take a look at the bitwise AND operation of two integers 12 and 25.
     * <p>
     * 12 = 00001100 (In Binary)
     * 25 = 00011001 (In Binary)
     * <p>
     * // Bitwise AND Operation of 12 and 25
     * 00001100
     * & 00011001
     * ____________
     * 00001000 = 8 (In Decimal)
     */

    public int hammingWeight(int n) {

        int counter = 0;
        while (n != 0) {
            counter = counter + (n & 1);

            n = n >>> 1;
        }
        return counter;
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
