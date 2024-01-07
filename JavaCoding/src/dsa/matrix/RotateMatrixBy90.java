package dsa.matrix;

import java.util.Arrays;

public class RotateMatrixBy90 {
    public static void main(String[] args) {
        rotate90Degrees(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
    }

    private static void rotate90Degrees(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length / 2; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][mat[i].length - 1 - j];
                mat[i][mat[i].length - 1 - j] = temp;
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = i + 1; j < mat[i].length; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        for (int[] arr : mat) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
