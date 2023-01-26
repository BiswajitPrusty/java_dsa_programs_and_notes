package questions.bitwise;

public class CheckKthBitIsSetOrNot {

    public static void main(String[] args) {
        System.out.println(checkKthBitIsSetOrNot(3, 2));
    }

    //using left shift operator
    public static boolean checkKthBitIsSetOrNot2(int n, int k) {
        // n = 5, k = 3
        //000...0101
        //000...0100   1 << (k - 1)

        int output = n & (1 << (k - 1));
        if (output == 1) return true;
        else return false;
    }

    //mzusing right shift operator
    public static boolean checkKthBitIsSetOrNot(int n, int k) {
        int output = (n >> (k - 1)) & 1;
        if (output == 1) return true;
        else return false;
    }
}
