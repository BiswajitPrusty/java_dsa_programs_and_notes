package dsa.recursion;

public class KthGrammar {

    public static int solve(int n, int k) {
        if (n == 1 && k == 1) {
            return 0;
        }
        int mid = (int) Math.pow(2, n - 1) / 2;
        if (k <= mid) {
            return solve(n - 1, k);
        }else{
            return 1 - solve(n - 1, k - mid);
        }
    }

    public static void main(String[] args) {
        System.out.println(solve(3, 2));
    }
}
