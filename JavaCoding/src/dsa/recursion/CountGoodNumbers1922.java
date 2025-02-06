package dsa.recursion;

public class CountGoodNumbers1922 {

    private static long MOD = 1_000_000_007;
    /*
    In this approach we are using permutation and combination
    lets take n = 5 (5 lengths of good number)
    here we will have five indexes
    _ _ _ _ _

    in the above five index we can have below numbers
    even = (n+1)/2
    odd = n/2

    places:
    in case of n = 5 length numbers:
    even = (n+1)/2 = 3
    odd = n/2 = 2

    now we need to know how many even and odd/prime numbers are in 0 to 9

    choices:
    [0, 2, 4, 6, 8].length = 5
    [2, 3, 5, 7].length = 4

    so the permutation and combination is applied on above size by
    number of choices to number of places
    ans: pow(5^even) * pow (4^odd)

    so write the power function that will solve the problem
     */

    public static int countGoodNumbers(long n) {
        long even = (n + 1) / 2;
        long odd = n / 2;
        long first = pow(5, even);
        long second = pow(4, odd);
        return (int) ((first * second) % MOD);
    }

    public static long pow(long x, long n) {
        if (n == 0) return 1;

        long half = pow(x, n / 2);

        return n % 2 == 0 ? (half * half) % MOD : (half * half * x) % MOD;
    }

    public static void main(String[] args) {
        System.out.println(countGoodNumbers(1));
    }
}
