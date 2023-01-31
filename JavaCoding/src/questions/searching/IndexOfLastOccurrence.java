package questions.searching;

public class IndexOfLastOccurrence {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3, 3, 4, 5, 6};
        System.out.println(lastOccurrenceRecursive(arr, 3, 0, arr.length - 1));
    }

    public static int lastOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                if (mid == arr.length - 1 || arr[mid] != arr[mid + 1]) {
                    return mid;
                } else
                    low = mid + 1;
            } else if (arr[mid] > target) high = mid + 1;
            else low = mid - 1;
        }
        return -1;
    }

    public static int lastOccurrenceRecursive(int[] arr, int target, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (arr[mid] > target) return lastOccurrenceRecursive(arr, target, low, mid - 1);
        else if (arr[mid] < target) return lastOccurrenceRecursive(arr, target, mid + 1, high);
        else {
            if (mid == arr.length - 1 || arr[mid] != arr[mid + 1]) {
                return mid;
            } else
                return lastOccurrenceRecursive(arr, target, mid + 1, high);
        }
    }
}
