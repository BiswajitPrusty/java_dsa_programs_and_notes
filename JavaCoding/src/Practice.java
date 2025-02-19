import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Practice {
    // Constants for MOD value and the pre-calculated array size
    private static final int ARRAY_SIZE = 10001;
    private static final int MOD = 1000000007;

    // Pre-calculated factorial and modular multiplicative inverse arrays
    private static final long[] factorialArray = new long[ARRAY_SIZE];
    private static final long[] inverseArray = new long[ARRAY_SIZE];

    // Static initializer block for pre-calculation of factorials and their inverses
    static {
        factorialArray[0] = 1;
        inverseArray[0] = 1;
        for (int i = 1; i < ARRAY_SIZE; ++i) {
            factorialArray[i] = factorialArray[i - 1] * i % MOD;
            inverseArray[i] = quickModularInverse(factorialArray[i], MOD - 2, MOD);
        }
    }

    // Method to compute the quick modular inverse using exponentiation
    public static long quickModularInverse(long base, long exponent, long modulus) {
        long result = 1;
        while (exponent != 0) {
            if ((exponent & 1) == 1) {
                result = result * base % modulus;
            }
            exponent >>= 1;
            base = base * base % modulus;
        }
        return result;
    }

    // Method to compute the combination (n choose k) under modulus
    public static long combination(int n, int k) {
        return (factorialArray[n] * inverseArray[k] % MOD) * inverseArray[n - k] % MOD;
    }

    // Method to count the number of good subsequences in the string s
    public int countGoodSubsequences(String s) {
        // Count array for each character with a maximum value tracker
        int[] characterCount = new int[26];
        int maxCount = 1;

        // Calculate character counts and find the max count
        for (int i = 0; i < s.length(); ++i) {
            maxCount = Math.max(maxCount, ++characterCount[s.charAt(i) - 'a']);
        }

        // Initialize the answer value which will be the final count
        long answer = 0;

        // Iterate over all possible subsequence lengths
        for (int i = 1; i <= maxCount; ++i) {
            long countForLength = 1;
            for (int j = 0; j < 26; ++j) {
                if (characterCount[j] >= i) {
                    countForLength = countForLength * (combination(characterCount[j], i) + 1) % MOD;
                }
            }
            // Subtract 1 because we are excluding the empty subsequence
            answer = (answer + countForLength - 1) % MOD;
        }

        // Return the result after casting to int
        return (int) answer;
    }

    public static void main(String[] args) {
        Practice p = new Practice();
        System.out.println(p.countGoodSubsequences("abca"));
    }
}