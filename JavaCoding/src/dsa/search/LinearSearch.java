package dsa.search;

import java.util.Arrays;

public class LinearSearch {


    public static void main(String[] args) {
        System.out.println(minimumNumber(new int[]{2, 8, 14, 78, 5, 1, 7}));
        System.out.println(Arrays.toString(search2DArray(new int[][]{{2, 8, 14}, {78, 5}, {1, 7}}, 78)));
    }

    static int[] search2DArray(int[][] arrays, int target) {

        for (int row = 0; row < arrays.length; row++) {
            for (int col = 0; col < arrays[row].length; col++) {
                if (arrays[row][col] == target) {
                    return new int[]{row, col};
                }
            }
        }
        return new int[]{-1, -1};
    }

    static int minimumNumber(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    static int searchInRange(int[] arr, int target, int start, int end) {
        if (arr.length == 0) return -1;

        for (int i = start; i <= end; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    static boolean searchString(String input, char target) {
        if (input.isEmpty()) return false;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == target) {
                return true;
            }
        }
        return false;
    }

    public static int linearSearch(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
