package questions.arrays;

import java.util.Arrays;

public class RemoveDuplicateFromSortedArray {
    public static void main(String[] args) {
        removeDuplicateEfficientApproach(new int[]{10, 20 , 20, 20, 30, 30});
    }

    public static void removeDuplicateEfficientApproach(int[] arr) {
        int result = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[result - 1] != arr[i]) {
                arr[result] = arr[i];
                result++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void removeDuplicateNaive(int[] arr) {
        int[] temp = new int[arr.length];
        temp[0] = arr[0];
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            if (temp[res - 1] != arr[i]) {
                temp[res] = arr[i];
                res++;
            }
        }
        System.out.println(Arrays.toString(temp ));
    }
}
