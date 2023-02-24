package questions.recursion;

public class PrintNumbers {

    public static void main(String[] args) {
        printNto1Numbers(5);
    }

    public static void printNto1Numbers(int n) {
        if (n == 0)
            return;
        System.out.println(n);
        printNto1Numbers(n - 1);
    }
}
