package dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortArray {

    public static void sort(List<Integer> nums) {
        if (nums.size() == 1)
            return;
        int lastElement = nums.size() - 1;
        int temp = nums.get(lastElement);
        nums.remove(lastElement);
        sort(nums);
        insert(nums, temp);

    }

    public static void insert(List<Integer> nums, int temp) {
        int lastElement = nums.size() - 1;
        if (nums.isEmpty() || nums.get(lastElement) <= temp) {
            nums.add(temp);
            return;
        }

        int val = nums.get(lastElement);
        nums.remove(lastElement);
        insert(nums, temp);
        nums.add(val);
    }

    public static void insert(int[] arr, int temp, int lastIndex) {
        if (lastIndex == -1 || arr[lastIndex] <= temp) {
            arr[lastIndex + 1] = temp;
            return;
        }
        int val = arr[lastIndex];
        insert(arr, temp, lastIndex - 1);
        arr[lastIndex + 1] = val;
    }

    public static void sort(int[] arr, int lastIndex) {
        if (lastIndex == 0) {
            return;
        }
        int temp = arr[lastIndex];
        sort(arr, lastIndex - 1);
        insert(arr, temp, lastIndex - 1);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(9);
        list.add(0);
        list.add(1);
        list.add(4);
        list.add(90);
        list.add(67);
        list.add(2);
        list.add(120);

        int[] arr = {9, 0, 1, 4, 90, 67, 2, 120};
        sort(arr, arr.length - 1);
        System.out.println(list);
        System.out.println(Arrays.toString(arr));
    }
}
