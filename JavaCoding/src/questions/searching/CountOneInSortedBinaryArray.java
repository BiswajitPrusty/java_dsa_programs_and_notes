package questions.searching;

public class CountOneInSortedBinaryArray {

    public static void main(String[] args) {
        System.out.println(countOnes(new int[]{0, 0, 0, 0, 1, 1, 1, 1}, 1));
    }

    public static int countOnes(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int count = -1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (arr[mid] == target) {
                if (mid == 0 || arr[mid - 1] != target) {
                    count = arr.length - mid;
                    return count;
                } else high = mid - 1;
            } else if (arr[mid] > target) high = mid - 1;
            else low = mid + 1;
        }

        return count;
    }
}
