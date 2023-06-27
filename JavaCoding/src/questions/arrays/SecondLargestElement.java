package questions.arrays;

public class SecondLargestElement {

    public static void main(String[] args) {
        System.out.println(secondHighestNumberBestApproach(new int[]{10, 15, 9}));
    }

    public static int secondHighestNumberBestApproach(int[] arr) {
        int res = - 1, largest = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[largest] < arr[i]) {
                res = largest;
                largest = i;
            } else if (arr[i] != arr[largest]) {
                if (res == -1 || arr[i] > arr[res]) {
                    res = i;
                }
            }
        }
        return res;
    }


    public static int findSecondLargestElement(int[] arr) {
        int target = -1;
        int firstHighestIndex = getFirstLargest(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[firstHighestIndex] != arr[i]) {
                if (target == -1) {
                    target = i;
                } else if (arr[target] < arr[i]) {
                    target = i;
                }
            }
        }
        return target;
    }

    public static int getFirstLargest(int[] arr) {
        int largest = 0;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (largest < arr[i]) {
                largest = arr[i];
                index = i;
            }
        }
        return index;
    }
}
