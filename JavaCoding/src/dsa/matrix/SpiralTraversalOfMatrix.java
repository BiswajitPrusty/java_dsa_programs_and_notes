package dsa.matrix;

import java.util.Arrays;

public class SpiralTraversalOfMatrix {

    public static void main(String[] args) {
        printSpiral(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
    }

    private static void printSpiral(int[][] arr) {
        int length = arr.length - 1;
        int top = 0, bottom = length, left = 0, right = length;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                System.out.print(arr[top][i] + ",");
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                System.out.print(arr[i][right] + ",");
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    System.out.print(arr[bottom][i] + ",");

                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(arr[i][left] + ",");
                }
                left++;
            }
        }

    }
}
