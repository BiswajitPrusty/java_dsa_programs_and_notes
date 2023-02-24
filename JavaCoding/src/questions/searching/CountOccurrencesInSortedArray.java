package questions.searching;

public class CountOccurrencesInSortedArray {

    public static void main(String[] args) {
        System.out.println(countOccurrence(new int[]{1, 2, 3, 4, 5, 5, 5, 6}, 5));
        System.out.println(countOccurrenceEfficient(new int[]{1, 2, 3, 4, 5, 5, 5, 6}, 5));
    }

    //time complexity log n + log n
    public static int countOccurrenceEfficient(int[] arr, int target) {
        int firstIndex = IndexOfFirstOccurrence.firstOccurrence(arr, target);
        if (firstIndex == -1) return 0;
        else {
            return IndexOfLastOccurrence.lastOccurrence(arr, target) - firstIndex + 1;
        }
    }

    //time complexity O(n)
    public static int countOccurrence(int arr[], int target) {
        int fistIndex = IndexOfFirstOccurrence.firstOccurrence(arr, target);
        int count = 0;
        for (int i = fistIndex; i < arr.length; i++) {
            if (arr[i] == target) {
                count++;
            } else
                break;
        }
        return count;
    }
}
