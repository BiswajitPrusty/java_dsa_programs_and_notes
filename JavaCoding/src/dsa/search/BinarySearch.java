package dsa.search;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, 11));
    }


    public static int search(int arr[], int target) {
        int start = 0, end = arr.length -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if(arr[mid] == target)
                return mid;
            else if (arr[mid] > target) {
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }
}
