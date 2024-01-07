package dsa.matrix;

import java.util.Arrays;

public class TransposeOfMatrix {
    public static void main(String[] args) {
        transpose(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
        transposeInPlace(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
    }

    private static void transposeInPlace(int[][] mat) {
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

    private static void transpose(int[][] mat) {
        int[][] temp = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                temp[j][i] = mat[i][j];
            }
        }
        for (int[] arr : temp) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
