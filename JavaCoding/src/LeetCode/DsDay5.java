package LeetCode;

import java.util.HashSet;

public class DsDay5 {
    public static void main(String[] args) {
        DsDay5 d = new DsDay5();
        System.out.println(d.climbStairs(3));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * You are climbing a staircase. It takes n steps to reach the top.
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     * Example 1:
     * Input: n = 2
     * Output: 2
     * Explanation: There are two ways to climb to the top.
     * 1. 1 step + 1 step
     * 2. 2 steps
     */
    public int climbStairs(int n) {

        if (n <= 1) return 1;

        int prev = 1, curr = 0, prev_prev = 1;
        for (int i = 2; i < n + 1; i++) {

            curr = prev + prev_prev;
            prev_prev = prev;
            prev = curr;
        }

        return curr;
    }

    /**
     * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
     * <p>
     * Each row must contain the digits 1-9 without repetition.
     * Each column must contain the digits 1-9 without repetition.
     * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
     */
    public boolean isValidSudoku(char[][] board) {

        HashSet<Character>[] row = new HashSet[9];
        HashSet<Character>[] columns = new HashSet[9];
        HashSet<Character>[] cube = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            row[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            cube[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current = board[i][j];

                if (current == '.') continue;

                int cubeIndex = (i / 3) * 3 + j / 3;

                if (row[i].contains(current) || columns[j].contains(current) || cube[cubeIndex].contains(current)) {
                    return false;
                }

                row[i].add(current);
                columns[j].add(current);
                cube[cubeIndex].add(current);
            }
        }


        return true;
    }

}
