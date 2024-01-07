package dsa.matrix;

public class PrintBoundaryElements {

    public static void main(String[] args) {
        printBoundaryElements(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
    }

    private static void printBoundaryElements(int[][] mat) {
        int R = 4, C = 4;
        for (int i = 0; i < C; i++)
            System.out.print(mat[0][i] + " ");
        for (int i = 1; i < R; i++)
            System.out.print(mat[i][C - 1] + " ");
        for (int i = C - 2; i >= 0; i--)
            System.out.print(mat[R - 1][i] + " ");
        for (int i = R - 2; i >= 1; i--)
            System.out.print(mat[i][0] + " ");
    }
}
