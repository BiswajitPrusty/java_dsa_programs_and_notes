package easyQuestions.maths;

import java.util.Arrays;

public class SieveOfEratosthenes {

    public static void main(String[] args) {
        gfgSieveOfEratosthenes(23);
    }

    public static void gfgSieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if (isPrime[i]) System.out.print(i + ", ");
        }
    }

    //my code
    public static void sieveOfEratosthenes(int n) {
        int[] allNums = new int[n];

        for (int i = 4; i < n; i += 2) {
            allNums[i] = 1;
        }
        for (int i = 6; i < n; i += 3) {
            allNums[i] = 1;
        }
        for (int i = 10; i < n; i += 5) {
            allNums[i] = 1;
        }
        for (int i = 2; i < n; i++) {
            if (allNums[i] == 0) System.out.print(i + " ");
        }
    }

    //naive approach 2 to print prime numbers
    public static void printPrimeNumbers2(int n) {
        for (int i = 2; i <= n; i++) {
            if (CheckPrimeNumber.efficientPrimeNumberCheck(i)) {
                System.out.print(i + ", ");
            }
        }
    }

    // naive approach 1 to print prime numbers
    public static void printPrimeNumbers(int n) {
        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) System.out.print(i + ", ");
        }
    }
}
