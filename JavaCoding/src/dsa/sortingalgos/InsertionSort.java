package dsa.sortingalgos;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        insertionSort(new int[]{3, 5, 1, 2, 7, 9, 6, 4});
    }

    public static void insertionSort(int[] arr) {
        int temp, j;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            j = i;
            while (j > 0 && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

}
