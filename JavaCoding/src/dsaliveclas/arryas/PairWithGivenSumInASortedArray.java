package dsaliveclas.arryas;

public class PairWithGivenSumInASortedArray {

    public static void main(String[] args) {
        System.out.println(isPrime(15));
    }
    public static boolean pairOfGivenSum(int[] nums, int sum) {
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                if (nums[i] + nums[j] == sum) return true;
        return false;
    }
    static int isPrime(int N){
        int isPrime = 1;

        for(int i = 2; i < N; i++){
            if(N%i == 0){
                isPrime = 0;
            }
        }

        return isPrime;
    }
}
