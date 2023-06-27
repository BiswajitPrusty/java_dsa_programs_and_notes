package questions.arrays;

import java.util.Arrays;

public class DeleteFromArray {


    public static void main(String[] args) {
        deleteFromArray(new int[]{3, 5, 1, 2, 7, 9, 6}, 5);
    }


    public static void deleteFromArray(int[] a, int num) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == num) {
                for (int j = i; j < a.length - 1; j++) {
                    a[j] = a[j + 1];
                }
                a[a.length - 1] = 0;
                break;
            }
        }

        System.out.println(Arrays.toString(a));
    }
}
