package LeetCode;

import java.util.HashMap;

public class EasyQuestions {

    public static void main(String[] args) {
        EasyQuestions e = new EasyQuestions();
        e.romanToInt("MCMXCIV");
        e.reverseString(new char[]{'h', 'e', 'l'});
    }

    public int maxDepth(TreeNode root) {

        return -1;
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
