package dsa.sortingalgos;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        bubbleSort(new int[]{3, 5, 1, 2, 7, 9, 6, 4});
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
