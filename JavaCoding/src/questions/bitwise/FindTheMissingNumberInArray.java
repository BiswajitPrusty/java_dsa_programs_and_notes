package questions.bitwise;

public class FindTheMissingNumberInArray {

    public static void main(String[] args) {
        System.out.println(findMissingNumber(new int[]{1, 2, 4, 5}));
    }

    /*
    We need to take the same approach to solve this problem as well.
    take XOR of all the numbers in the array and then, do XOR of the result with
    all the numbers from 1 to n plus 1.
     */
    public static int findMissingNumber(int[] a) {
        int ans = 0;
        for (int i = 0; i < a.length; i++) {
            ans = ans ^ a[i];
        }
        for (int i = 1; i <= a.length + 1; i++) {
            ans = ans ^ i;
        }
        return ans;
    }
}
