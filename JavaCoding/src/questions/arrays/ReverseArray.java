package questions.arrays;

import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) {
        reverse2(new int[]{10, 1, 7, 30});
    }

    public static void reverseArray(int[] arr) {
        int mid = arr.length / 2;
        for (int i = 0; i < mid; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void reverse2(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
        System.out.println(Arrays.toString(arr));
    }

}
