package questions.recursion;

public class RopeCuttingProblem {

    public static void main(String[] args) {
        System.out.println(maxPieces(23, 11, 9, 12));
    }

    public static int maxPieces(int n, int a, int b, int c) {

        if (n == 0) return 0;
        if (n < 0) return -1;
        int max = Math.max(Math.max(
                maxPieces(n - a, a, b, c),
                maxPieces(n - b, a, b, c)),
                maxPieces(n - c, a, b, c)
        );

        if (max == -1) return -1;
        else return max + 1;
    }
}
