package questions.maths;

public class CountTheDigitsThatDivideNumber2520 {

    public static void main(String[] args) {
        countDigits(121);
    }
    public static int countDigits(int num) {
        int count = 1, temp = num;

        while (temp < 0) {
            int lastDigit = temp % 10;

            if (num % lastDigit == 0) count++;

            temp /= 10;
        }

        return count;
    }
}
