package questions.maths;

import java.util.ArrayList;

public class CountPrimes204 {

    public static void main(String[] args) {
        countPrimes(499979);
    }
    public static int countPrimes(int n) {
        //using sieve of eratosthenes
        int count = 0;
        int[] arr = new int[n];
        for(long i = 2; i < n; i++){
            if(arr[(int)i] == 0){
                count++;
                for(long j = i * i; j < n; j +=i){
                    arr[(int)j] = 1;
                }
            }
        }

        return count;
    }
}
