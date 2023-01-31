package questions.searching;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(binarySearchRecursive(new int[]{1, 2, 3, 4, 5}, 3, 0, 5));
    }

    public static int binarySearchRecursive(int[] nums, int target, int low, int high) {
        if (low > high) return -1;
        int mid = low + (high - low) / 2;
        if (nums[mid] == target) return mid;
        else if (nums[mid] > target) return binarySearchRecursive(nums, target, low, mid - 1);
        else return binarySearchRecursive(nums, target, mid + 1, high);
    }

    public static int searchArray(int[] a, int target) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == target) return mid;
            else if (a[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
}
