package questions.strings;

import java.util.Arrays;

public class StringCompression443 {

    public static void main(String[] args) {
        System.out.println(0/10);
        System.out.println(compressTwoPointerApproach(new char[]{'o','o','o','o','o','o','o','o','o','o'}));
    }

    public static int compressTwoPointerApproach(char[] chars) {
        if (chars.length == 1) return 1;
        int index = 0, j = 0;

        for (int i = 0; i < chars.length; i = j) {
            int count = 0;
            while (j < chars.length && chars[i] == chars[j]) {
                count++;
                j++;
            }
            if (count == 1) {
                chars[index++] = chars[i];
            } else if (count > 1) {
                chars[index++] = chars[i];
                index = convertToChar(count, chars, index);
            }
        }
        System.out.println(Arrays.toString(chars));
        return index;
    }

    public static int compressTestCaseFailed(char[] chars) {
        if (chars.length == 1) return 1;
        int count = 1;
        int index = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == chars[i]) {
                count++;
            } else if (count > 1) {
                chars[index++] = chars[i - 1];
                index = convertToCharViaString(count, chars, index);
                count = 1;
            } else {
                index++;
            }
        }
        if (count >= 2) {
            chars[index++] = chars[chars.length - 1];
            index = convertToChar(count, chars, index);
        }
        index = chars.length == 3 ? index + 1 : index;
        System.out.println(Arrays.toString(chars));

        return index;
    }

    public static int compress(char[] chars) {
        if (chars.length == 1) return 1;
        int index = 0;
        int count = 0;
        int[] allChar = new int[256];
        for (int i = 0; i < chars.length; i++) {
            allChar[chars[i]]++;
        }
        for (int i = 0; i < allChar.length; i++) {
            int countOfChar = allChar[i];
            if (countOfChar == 1) {
                index++;
                continue;
            } else if (countOfChar > 0) {
                chars[index++] = (char) i;
                index = convertToChar(countOfChar, chars, index);
            }
        }
        System.out.println(Arrays.toString(chars));
        return index;
    }

    private static int convertToCharViaString(int num, char[] chars, int index) {
        String s = num + "";
        for (char i : s.toCharArray()) {
            chars[index++] = i;
        }
        return index;
    }

    private static int convertToChar(int num, char[] chars, int index) {
        int size = 0;
        int rev = 0;
        while (num > 0) {
            int temp = num % 10;
            rev = rev * 10 + temp;
            num /= 10;
            size++;
        }
        num = 0;
        char[] c = new char[size];
        while (rev > 0) {
            int temp = rev % 10;
            c[num++] = Character.forDigit(temp, 10);
            rev /= 10;
        }
        for (char i : c) {
            chars[index++] = i;
        }
        return index;
    }
}
