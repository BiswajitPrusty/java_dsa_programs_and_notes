package easyQuestions.arrays;

public class SearchInsertPosition {
    public static void main(String[] args) {
        SearchInsertPosition s = new SearchInsertPosition();
        System.out.println(s.binarySearch(new int[]{1, 3, 5, 6}, 7));
    }

    public int searchInsert(int[] nums, int target) {

        return binarySearch(nums, target)+ 1;
    }

    public int binarySearch(int[] a, int find) {
        int high = a.length - 1;
        int low = 0;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (find == a[mid]) {
                return mid;
            }
            if (find < a[mid]) {
                high = mid - 1;
            }
            if (find > a[mid]) {
                low = mid + 1;
            }
        }

        System.out.println(mid);
        return low;
    }
}
