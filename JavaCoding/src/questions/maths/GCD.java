package questions.maths;

public class GCD {

    public static void main(String[] args) {
        System.out.println(gcdRecursive(10, 15));
    }

    public static int gcdRecursive(int a, int b) {
        if(b == 0) return a;
        return gcdRecursive(b, a % b);
    }
    //efficient approach using euclidean Algorithm
    public static int gcd(int a, int b) {
        while (a != b) {
            if (a > b) a = a - b;
            else b = b - a;
        }
        return a;
    }

    // naive approach
    public static int greatestCommonDivisor(int a, int b) {
        int gcd = Math.max(a, b);
        while (gcd > 0) {
            if (a % gcd == 0 && b % gcd == 0) break;
            gcd--;
        }
        return gcd;
    }
}
