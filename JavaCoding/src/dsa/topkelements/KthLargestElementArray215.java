package dsa.topkelements;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementArray215 {

    public static int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        return quickSort(nums, 0, nums.length - 1, k);
    }

    public static int quickSort(int[] nums, int l, int r, int k) {
        int pivot = nums[r], p = l;

        for (int i = l; i < r; i++) {
            if (nums[i] < pivot) {
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;
                p++;
            }
        }
        nums[r] = nums[p];
        nums[p] = pivot;

        if(p < k) return quickSort(nums, p + 1, r, k);
        else if(p > k) return quickSort(nums, l, p - 1, k);
        else return nums[p];

    }

    public static int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            pq.offer(nums[i]);
            pq.poll();
        }
        return pq.poll();
    }

        public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6,6};
        //using quick sort algo worst case: O(n*n)
        System.out.println(findKthLargest(nums,4));

        //using heap data structure O(n + k log n)
        System.out.println(findKthLargest2(nums,4));
    }

}
