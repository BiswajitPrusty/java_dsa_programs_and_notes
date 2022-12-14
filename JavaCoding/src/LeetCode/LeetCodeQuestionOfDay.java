package LeetCode;

import java.util.Arrays;

public class LeetCodeQuestionOfDay {

    public static void main(String[] args) {
        LeetCodeQuestionOfDay l = new LeetCodeQuestionOfDay();
        int[][] matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        System.out.println(l.minFallingPathSum1(matrix));
    }


    public int minFallingPathSum1(int[][] a) {

        int rows = a.length;
        int cols = a[0].length;

        int dp[][] = new int[rows][cols + 2];

        //copy first row into dp
        for (int i = 0; i < cols; i++) {
            dp[0][i + 1] = a[0][i];
        }

        for (int i = 0; i < rows; i++) {
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][cols + 1] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int minNeighbor = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                minNeighbor = Math.min(minNeighbor, dp[i - 1][j + 1]);
                dp[i][j] = a[i][j - 1] + minNeighbor;
            }
        }
        return Arrays.stream(dp[rows - 1]).min().getAsInt();
    }

    public int minFallingPathSum(int[][] matrix, int n, int row, int col) {
        // base case: if we've reached the last row, return the value of the current element
        if (row == n - 1) return matrix[row][col];

        // recursive case: sum the current element with the minimum of the three possible next elements
        int left = minFallingPathSum(matrix, n, row + 1, col - 1);
        int below = minFallingPathSum(matrix, n, row + 1, col);
        int right = minFallingPathSum(matrix, n, row + 1, col + 1);
        return matrix[row][col] + Math.min(Math.min(left, below), right);
    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        return minFallingPathSum(matrix, n, 0, 0);
    }

}
