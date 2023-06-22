package questions.arrays;

public class LargestElementInArray {

    public static void main(String[] args) {
        findLargestElement(new int[]{2, 5, 3, 7});
    }

    public static int findLargestElement(int[] arr) {
        int min = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {

            if (min < arr[i]) {
                min = arr[i];
                index = i;
            }
        }
        System.out.println("Largest value is " + min + " at index " + index);
        return min;
    }
}
