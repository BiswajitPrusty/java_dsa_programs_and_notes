package questions.bitwise;

import java.util.Arrays;

public class FlippingImage832 {

    public static void main(String[] args) {
        FlippingImage832 fl = new FlippingImage832();
        fl.flipAndInvertImage(new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}});
    }

    public int[][] flipAndInvertImageUsingBit(int[][] A) {
        int C = A[0].length;
        for (int[] row: A)
            for (int i = 0; i < (C + 1) / 2; ++i) {
                int tmp = row[i] ^ 1;
                row[i] = row[C - 1 - i] ^ 1;
                row[C - 1 - i] = tmp;
            }

        return A;
    }
    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            reverseArray(image[i]);
        }
        return image;
    }

    public void reverseArray(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        for (int k = 0; k < arr.length; k++) {
            arr[k] = arr[k] == 0 ? 1 : 0;

        }
    }
}
