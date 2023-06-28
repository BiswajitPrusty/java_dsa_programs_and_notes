package questions.arrays;

import java.util.Arrays;

public class MoveZeroToEnd {

    public static void main(String[] args) {
        moveZerosToEnd(new int[]{0, 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9});
    }

    public static void moveZerosToEnd(int[] arr) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
                index++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }


}
