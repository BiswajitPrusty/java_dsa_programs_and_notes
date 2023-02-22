package questions.recursion;

public class PrintNumbers1toN {

    public static void main(String[] args) {
        printNto1Numbers(5);
    }
    public static void printNto1Numbers(int n) {
        if (n == 0) {
            return;
        }
        printNto1Numbers(n - 1);
        System.out.println(n);
    }
}
