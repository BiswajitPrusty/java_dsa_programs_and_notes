package questions.bitwise;

public class FindTheOnlyOddOccurringNumber {

    public static void main(String[] args) {
        System.out.println(findTheOnlyOddOccurringNumber(new int[]{4, 4, 4, 5, 5}));
        System.out.println(findOdd(new int[]{4, 3,4, 4, 4, 5, 5}));
    }

    //better solution with O(n) time complexity
    public static int findOdd(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans = ans ^ arr[i];
        }
        return ans;
    }

    //naive approach with time complexity O(n^2)
    public static int findTheOnlyOddOccurringNumber(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            int n = arr[i];
            for (int j = 0; j < arr.length; j++) {
                if (n == arr[j]) {
                    count++;
                }
            }
            if (count % 2 != 0) {
                return n;
            }
        }
        return ans;
    }
}
