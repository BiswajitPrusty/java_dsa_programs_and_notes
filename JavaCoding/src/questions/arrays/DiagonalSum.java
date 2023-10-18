package questions.arrays;

public class DiagonalSum {
    public static int diagonalSum(int[][] mat) {
        int outerLength = mat.length;
        int innerLength = mat[0].length;
        int sum = 0;

        for (int i = 0, j = 0; i < outerLength && j < innerLength; j++, i++) {
            sum += mat[i][j];
        }

        for (int i = 0, j = innerLength - 1; i < outerLength && j >= 0; i++, j--) {
            if (i != j)
                sum += mat[i][j];
        }

        return sum;
    }
}
