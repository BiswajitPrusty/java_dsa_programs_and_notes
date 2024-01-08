package questions.matrix;

public class DeleteGreatestValue2500 {

    public static void main(String[] args) {
        System.out.println(deleteGreatestValue(new int[][]{{1, 2, 4}, {3, 3, 1}}));
    }

    public static int deleteGreatestValue(int[][] grid) {
        int m = grid.length, n = grid[0].length, maxSum = 0;
        while (n > 0) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                int rowMax = Integer.MIN_VALUE;
                int max_index = -1;
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] > rowMax) {
                        rowMax = grid[i][j];
                        max_index = j;
                    }
                }
                grid[i][max_index] = grid[i][n - 1];
                grid[i][n - 1] = 0;
                max = Math.max(max, rowMax);
            }
            maxSum += max;
            n--;
        }
        return maxSum;
    }
}
