package questions.maths;

public class TrailingZerosInFactorial {

    public static void main(String[] args) {
        System.out.println(trailingZeros(25));
        System.out.println(findTrailingZerosInFactorial(25));
    }

    //naive method
    public static int trailingZeros(int num) {
        int fact = 1;
        for (int i = 2; i <= num; i++) {
            fact *= i;
        }
        int counter = 0;
        while (fact % 10 == 0) {
            counter++;
            fact /= 10;
        }

        return  counter;
    }

    public static int findTrailingZerosInFactorial(int nums) {
        int counter = 0;
        for (int i = 5; i <= nums; i *= 5) {
            counter += nums / i;
        }
        return counter;
    }


}
