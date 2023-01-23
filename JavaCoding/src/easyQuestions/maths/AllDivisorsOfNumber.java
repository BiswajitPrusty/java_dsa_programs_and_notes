package easyQuestions.maths;

public class AllDivisorsOfNumber {

    public static void main(String[] args) {
        allDivisorsOf(7);
    }

    public static void allDivisors(int n) {
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + ", ");
                if (i != n / i) {
                    System.out.print(i + ", ");
                }
            }
        }
    }

    public static void allDivisorsOf(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + ",");
            }
        }
    }
}
