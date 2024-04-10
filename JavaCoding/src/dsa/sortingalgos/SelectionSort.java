package dsa.sortingalgos;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        selectionSort(new int[]{3, 5, 1, 2, 7, 9, 6, 4});
    }

    public static void selection(int[] arr) {
        int min, temp = 0;
        for (int i = 0; i < arr.length; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {

            }

        }
    }

    public static void selectionSort(int[] arr) {
        int min, temp = 0;
        for (int i = 0; i < arr.length; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

}
