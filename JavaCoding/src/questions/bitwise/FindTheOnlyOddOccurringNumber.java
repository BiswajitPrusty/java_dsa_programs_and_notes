package questions.bitwise;

public class FindTheOnlyOddOccurringNumber {

    public static void main(String[] args) {
        System.out.println(findTheOnlyOddOccurringNumber(new int[]{4, 4, 4, 5, 5}));
    }

    //naive approach with time complexity O(n^2)
    public static int findTheOnlyOddOccurringNumber(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            int n = arr[i];
            for (int j = 0; j < arr.length; j++) {
                if (n != 0 && n == arr[j]) {
                    count++;
                    arr[j] = 0;
                }
            }
            if (count % 2 != 0) {
                return n;
            }
        }
        return ans;
    }
}
