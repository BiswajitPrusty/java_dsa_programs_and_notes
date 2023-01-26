package questions.maths;

public class PrimeFactors {

    public static void main(String[] args) {
        printPrimeFactor(315);
    }

    //efficient approach
    static void printPrimeFactors(int n) {
        if (n <= 1) return;

        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                System.out.print(i + ", ");
                n /= i;
            }
        }
        if (n > 1) {
            System.out.println(n);
        }
    }

    //naive approach O(n2 log n)
    public static void anotherApproach(int n) {
        for (int i = 2; i < n; i++) {
            if (CheckPrimeNumber.efficientPrimeNumberCheck(i)) {
                int x = i;
                while (n % x == 0) {
                    System.out.print(i + ", ");
                    x = x * i;
                }
            }
        }
    }

    // my logic
    public static void printPrimeFactor(int n) {
        int i = 2;
        while (n != 1) {
            if (n % i == 0) {
                n = n / i;
                System.out.print(i + ", ");
            } else i++;
        }
    }
}
