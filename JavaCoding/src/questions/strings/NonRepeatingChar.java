package questions.strings;

import java.util.Arrays;

public class NonRepeatingChar {

    public static void main(String[] args) {
        System.out.println(nonReapeatingCharSingleLoop("geeksforgeeks"));
    }

    public static int nonReapeatingCharSingleLoop(String str) {
        int[] chars = new int[256];
        Arrays.fill(chars, -1);
        for (int i = 0; i < str.length(); i++) {
            if (chars[str.charAt(i)] == -1) {
                chars[str.charAt(i)] = i;
            }else{
                chars[str.charAt(i)] = -2;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] >= 0)
             res = Math.min(res, chars[i]);
        }
        return res;
    }

    public static int nonRepeatingCharLinear(String str) {
        int[] chars = new int[256];
        for (int i = 0; i < str.length(); i++) {
            chars[str.charAt(i)]++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (chars[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
    //naive approach
    public static int nonRepeatingChar(String str) {
        for (int i = 0; i < str.length(); i++) {
            boolean repeated = false;
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    repeated = true;
                    break;
                }
            }
            if (!repeated) return i;
        }
        return -1;
    }
}
