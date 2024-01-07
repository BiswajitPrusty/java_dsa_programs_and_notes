package dsa.matrix;

import java.util.Arrays;

public class MedianOfRowWiseMatrix {

    public static void main(String[] args) {
        findMedian(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
    }

    private static void findMedian(int[][] arr) {
        int index = 0;
        int[] temp = new int[arr.length * arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                temp[index++] = arr[i][j];
            }
        }
        Arrays.sort(temp);
        System.out.println(temp[temp.length/2]);
    }
}
