package questions.recursion;

public class SumOfNaturalNumbers {

    public static void main(String[] args) {
        System.out.println(sumOfNaturalNumbers(5));
    }

    public static int sumOfNaturalNumbers(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sumOfNaturalNumbers(n - 1);
    }

    public static int sumOfNaturalNumbersWithFormula(int n) {
        return n * (n + 1) / 2;
    }
}
