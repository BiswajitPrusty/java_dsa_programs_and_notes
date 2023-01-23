package questions.maths;

public class PrimeArrangements1175 {

    public int numPrimeArrangements(int n) {
        int[] a = new int[n + 1];
        // mark 2,3,5 multiples as 1 as they are not prime numbers
        for (int i = 2; i * i <= n; i++) {
            if (a[i] == 0) {
                for (int j = i * i; j <= n; j += i)
                    a[j] = 1;
            }
        }
        int count = 0;
        //count all the prime numbers
        for (int i = 2; i <= n; i++)
            if (a[i] == 0) count++;

        int MOD = (int) (1e9 + 7);
        long ret = 1;

        for (int i = 2; i <= count; i++) ret = (ret * i) % MOD;
        for (int i = 2; i <= n - count; i++) ret = (ret * i) % MOD;
        return (int) ret;
    }
}
