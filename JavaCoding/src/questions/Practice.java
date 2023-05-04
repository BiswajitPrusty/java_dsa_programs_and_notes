package questions;

interface A {
    void hello();
}

interface B {
    void hello();
}

public class Practice implements A, B {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};

        arrayQuestions(arr, 3);
        Practice p = new Practice();
        p.hello();
    }


    public static void arrayQuestions(int arr[], int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                System.out.println(target + " is at: " + mid);
                break;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
    }

    @Override
    public void hello() {
        System.out.println("hello world");
    }
}