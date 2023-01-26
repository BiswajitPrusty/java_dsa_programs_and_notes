package questions.bitwise;

public class PowerOfTwo {

    public static void main(String[] args) {
        System.out.println(isPowerOf2(4));
    }

    //	• Brian and Kerningham Algorithm
    public static boolean isPowerOf2(int n) {
        if (n == 0) return false;
        return (n & (n - 1)) == 0;
    }

    //	• Brian and Kerningham Algorithm
    public static boolean isPowerOf2OneLineCode(int n) {
        return (n != 0) && (n & (n - 1)) == 0;
    }

    //naive approach
    public static boolean isPowerOfTwo(int n) {
        while (n != 1) {
            if (n % 2 != 0) return false;
            n /= 2;
        }
        return true;
    }
}
