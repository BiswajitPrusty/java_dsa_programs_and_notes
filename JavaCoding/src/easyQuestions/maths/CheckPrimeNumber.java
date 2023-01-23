package easyQuestions.maths;

public class CheckPrimeNumber {

    public static void main(String[] args) {
        System.out.println(efficientPrimeNumberCheck(5));
    }

    //more efficient by checking if the number is divisible of 2 and 3 we can save many iteration
    public static boolean efficientPrimeNumberCheck(int num) {
        if (num == 2 || num == 3) return true;
        if (num == 1 || num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }

    //efficient way sqrt(n)
    public static boolean isPrimeFaster(int num) {
        if (num == 1) return false;
        for (int i = 2; i * i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }


    //Naive method
    public static boolean isPrime(int num) {
        if (num == 1) return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
