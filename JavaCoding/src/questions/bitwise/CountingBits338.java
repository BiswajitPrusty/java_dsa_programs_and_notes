package questions.bitwise;

import java.util.Arrays;

public class CountingBits338 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2)));
    }

    public static int[] countBits(int n) {
        int a[] = new int[n + 1];
        for (int i = 0; i < a.length; i++) {
            int count = 0;
            int temp = i;
            while (temp != 0) {
                if ((temp & 1) == 1) {
                    count++;
                    temp = temp >> 1;
                } else temp = temp >> 1;
            }
            a[i] = count;
        }
        return a;
    }
}
