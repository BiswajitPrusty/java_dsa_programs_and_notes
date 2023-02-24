package questions.recursion;

public class SumOfDigitUsingRecursion {

    public static void main(String[] args) {
        System.out.println(sumOfDigits(9987));
    }

    public static int sumOfDigits(int num) {
        if (num <= 0) {
            return 0;
        }
        return num % 10 + sumOfDigits(num / 10);
    }
}
