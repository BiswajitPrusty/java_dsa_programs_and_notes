package questions.arrays;

public class CheckIfSorted {

    public static void main(String[] args) {
        System.out.println(checkSorted(new int[]{1, 2, 5, 3, 4}));
    }

    public static boolean checkSorted(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
