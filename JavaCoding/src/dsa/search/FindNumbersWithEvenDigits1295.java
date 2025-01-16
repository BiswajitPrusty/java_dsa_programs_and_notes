package dsa.search;

public class FindNumbersWithEvenDigits1295 {

    public static void main(String[] args) {
        System.out.println(findNumbers(new int[]{12, 345, 2, 6, 7412}));
    }

    public static int findNumbers(int[] nums) {
        int evenDigits = 0;
        for (int num : nums) {
            if (isEvenDigits(num))
                evenDigits++;
        }
        return evenDigits;
    }

    public static boolean isEvenDigits(int num) {
        int counter = 0;
        while (num > 0) {
            counter++;
            num /= 10;
        }
        return counter % 2 == 0;
    }
}
