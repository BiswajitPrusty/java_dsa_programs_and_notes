package LeetCode;

import java.util.HashMap;

public class DsDay2 {


    public static void main(String[] args) {

        int[] a = {-3, 4, 3, 90};
        var response = twoSumSecondApproach(a, 0);

        for (int i : response) {
            System.out.print(i + ", ");
        }
    }

    /**
     * * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     * * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * [-3,4,3,90]
     * output : [0,2] target : 0
     */
    public static int[] twoSumSecondApproach(int[] nums, int target) {
        int index[] = new int[2];
        HashMap<Integer, Integer> a = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int secondNumber = target - nums[i];
            if (a.containsKey(secondNumber)) {
                index[1] = i;
                index[0] = a.get(secondNumber);
            }

            a.put(nums[i], i);

        }
        return index;
    }

    /**
     * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
     * representing the number of elements in nums1 and nums2 respectively.
     * <p>
     * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
     * <p>
     * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
     * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
     * and the last n elements are set to 0 and should be ignored. nums2 has a length of n
     * <p>
     * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * Output: [1,2,2,3,5,6]
     * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
     * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0 && m != 0) {
            return;
        }
        if (m == 0 && n != 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        }

        for (int i = m - 1, j = 0; j < n; i++, j++) {
            nums1[i] = nums2[j];
        }
        quickRecursion(nums1, 0, nums1.length - 1);

    }

    public void quickRecursion(int a[], int low, int high) {
        int p = divide(a, low, high);
        if (low < p - 1) {
            quickRecursion(a, low, p - 1);
        }
        if (high > p) {
            quickRecursion(a, p, high);
        }
    }

    public int divide(int a[], int low, int high) {
        int pi = a[(low + high) / 2];
        while (low <= high) {
            while (a[low] < pi) {
                low++;
            }
            while (a[high] > pi) {
                high--;
            }
            if (low <= high) {
                int temp = a[low];
                a[low] = a[high];
                a[high] = temp;
                low++;
                high--;
            }
        }
        return low;
    }

    public int[] twoSum(int[] nums, int target) {
        int a[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    a[0] = i;
                    a[1] = j;
                    return a;
                }
            }
        }
        return a;

    }
}
