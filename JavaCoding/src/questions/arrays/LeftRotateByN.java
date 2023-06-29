package questions.arrays;

import java.util.Arrays;

public class LeftRotateByN {

    public static void main(String[] args) {
        rotateByNWithOutAnyExtraSpace(new int[]{1, 2, 3, 4, 5, 6, 7}, 2);
    }

    public static void rotateByNWithOutAnyExtraSpace(int[] arr, int d) {
        reverse(arr, 0, d - 1);
        reverse(arr, d, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }


    public static void reverse(int[] arr, int low, int high) {
        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            high--;
            low++;
        }
    }


    public static void leftRotateByNthPlace(int[] arr, int d) {

        int[] tempArray = new int[d];
        for (int i = 0; i < d; i++) {
            tempArray[i] = arr[i];
        }

        for (int i = d; i < arr.length; i++) {
            arr[i - d] = arr[i];
        }
        for (int i = 0; i < d; i++) {
            arr[arr.length - d + i] = tempArray[i];
        }

    }

    public static void naiveApproach(int[] arr, int d) {
        for (int i = 0; i < d; i++) {
            leftRotateByOne(arr);
        }
    }

    /*
    Input:  arr[] = {1,2,3,4,5}
    Output: arr[] = {2,3,4,5,1}
     */
    public static void leftRotateByOne(int[] arr) {
        int last = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = last;

    }
}
