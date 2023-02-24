package questions.searching;

public class IndexOfFirstOccurrence {

    public static void main(String[] args) {
        System.out.println(firstOccurrence(new int[]{1, 2, 3, 3, 3, 4, 5}, 3));
    }

    public static int firstOccurrence(int arr[], int target) {
        int low = 0, high = arr.length;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                if (mid == 0 || arr[mid] != arr[mid - 1]) return mid;
                else high = mid - 1;
            } else if (arr[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    public static int firstOccurrenceUsingRecursion(int[] a, int target, int low, int high) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (a[mid] > target) return firstOccurrenceUsingRecursion(a, target, low, mid - 1);
        else if (a[mid] < target) return firstOccurrenceUsingRecursion(a, target, mid + 1, high);
        else {
            if (mid == 0 || a[mid] != a[mid - 1]) return mid;
            else return firstOccurrenceUsingRecursion(a, target, low, mid - 1);
        }
    }

    public static int indexOfFirstOccurrence(int[] a, int target) {
        int high = a.length - 1, low = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == target) return mid;
            else if (a[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    public static int naiveApproach(int[] a, int target) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
