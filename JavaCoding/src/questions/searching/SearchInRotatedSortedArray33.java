package questions.searching;

public class SearchInRotatedSortedArray33 {

    public static void main(String[] args) {
        System.out.println(searchRotatedArrayWithAllEdgeCase(new int[]{3, 1}, 1));
    }

    // all edge case handled code.
    public static int searchRotatedArrayWithAllEdgeCase(int[] arr, int target) {

        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return mid;

            if (arr[mid] >= arr[low]) {
                if (target >= arr[low] && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            if (arr[mid] <= arr[high]) {
                if (target <= arr[high] && target > arr[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    //my approach to the code with lots of edge case to handle
    public static int searchRotatedArray(int[] arr, int target) {
        int low = 0, high = arr.length - 1, mid = low + (high - low) / 2;

        if (arr[mid] > arr[0] && arr[0] <= target || arr[mid] == target) {
            if (arr[mid] != target) {
                high = mid - 1;
            } else return mid;
        } else {
            low = mid + 1;
        }

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
}
