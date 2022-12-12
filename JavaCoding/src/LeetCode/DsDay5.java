package LeetCode;

import java.util.HashSet;

public class DsDay5 {
    public static void main(String[] args) {
        DsDay5 d = new DsDay5();
        char[][] sudo = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
//        System.out.println(d.climbStairs(3));
        d.isValidSudoku(sudo);
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
        /**
         * creating 3 sets array of length 9 as in a sudoku we have 9 rows and 9 columns and from those rows and columsn
         * there are sub boxes.
         *
         * we are going to store all the value in these sets
         * */
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

                //this is the formula to calculate the index of cube(box) with index of row and column, i.e to which box the current value belongs to.
                int cubeIndex = (i / 3) * 3 + j / 3;

                if (row[i].contains(current) || columns[j].contains(current) || cube[cubeIndex].contains(current)) {
                    return false;
                }

                //add the current number to its row, column and cubes for checking if it contains duplicate in next iteration.
                row[i].add(current);
                columns[j].add(current);
                cube[cubeIndex].add(current);
            }
        }


        return true;
    }

}
