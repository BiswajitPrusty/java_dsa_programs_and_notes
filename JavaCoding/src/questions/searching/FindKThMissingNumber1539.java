package questions.searching;

import java.util.ArrayList;
import java.util.List;

public class FindKThMissingNumber1539 {


    public static void main(String[] args) {
        System.out.println(5/2 * 2);
        System.out.println(findKthPositiveUsingBinarySearch(new int[]{2,3,4,7,11}, 5));
    }

    public static int findKthPositiveUsingBinarySearch(int[] arr, int k) {
        int start = 0;
        int end = arr.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] - (mid + 1) >= k) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start + k;
    }

    /*
    Input: arr = [2,3,4,7,11], k = 5
    Output: 9
     */
    public static int findKthPositive(int[] arr, int k) {
        List<Integer> missingNumbers = new ArrayList<>();
        int num = 1;
        int count = k;
        while (num < arr[0]) {
            missingNumbers.add(num++);
            count--;
        }
        for (int i = 1; i < arr.length; i++) {
            num = arr[i - 1];
            if (arr[i] - arr[i - 1] != 1) {
                while (++num < arr[i]) {
                    missingNumbers.add(num);
                    if (count-- == 0) {
                        return missingNumbers.get(k - 1);
                    }
                }
            }
        }
        int lastNumber = arr[arr.length - 1] + 1;
        while (count >= 0) {
            missingNumbers.add(lastNumber++);
            count--;
        }
        return missingNumbers.get(k - 1);

    }
}
