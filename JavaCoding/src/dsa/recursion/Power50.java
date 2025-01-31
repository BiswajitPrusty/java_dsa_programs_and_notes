package dsa.recursion;

public class Power50 {
    public double myPow(double x, int n) {
        // Base case
        if (n == 0) {
            return 1.0;
        }

        // Handle negative exponent
        if (n < 0) {
            x = 1 / x;
            if (n == Integer.MIN_VALUE) {
                // Prevent overflow: Convert n to positive safely
                n = -(n + 1);
                return x * myPow(x, n);
            }
            n = -n;
        }

        // Recursive case: Exponentiation by squaring
        double half = myPow(x, n / 2);

        // If n is even, return half * half
        // If n is odd, return half * half * x
        return (n % 2 == 0) ? half * half : half * half * x;
    }

    public static void main(String[] args) {
        Power50 sol = new Power50();
        System.out.println(sol.myPow(2.00000, 10));  // Output: 1024.00000
//        System.out.println(sol.myPow(2.10000, 3));   // Output: 9.26100
//        System.out.println(sol.myPow(2.00000, -2));  // Output: 0.25000
    }
}
