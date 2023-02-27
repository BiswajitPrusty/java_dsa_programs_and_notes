package questions.strings;

import java.util.Arrays;

public class LeftMostRepeatingCharacterIndex {

    public static void main(String[] args) {
        System.out.println(leftMostRepeating("abcda"));
    }

    public static int leftMostRepeating(String s) {
        boolean[] visited = new boolean[256];
        int result = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (visited[s.charAt(i)]) {
                result = i;
            } else {
                visited[s.charAt(i)] = true;
            }
        }
        return result;
    }

    public static int leftMostRepeatingCharSingleLoop(String s) {
        int[] count = new int[256];
        Arrays.fill(count, -1);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            int index = count[s.charAt(i)];
            if (index == -1) {
                count[s.charAt(i)] = i;
            } else {
                result = Math.min(result, index);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static int leftMostRepeatingCharEfficent(String str) {
        int[] count = new int[256];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i)] > 1) {
                return i;
            }
        }
        return -1;
    }

    public static int leftMostRepeatingChar(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            for (int j = i + 1; j < str.length(); j++) {
                if (c == str.charAt(j)) {
                    return i;
                }
            }
        }
        return -1;
    }


}
