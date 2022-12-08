package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DsDay4 {

    public static void main(String[] args) {
        DsDay4 d = new DsDay4();
//        System.out.println(d.generate(5));

        var v = d.matrixReshape(new int[][]{{1, 2}, {3, 4}}, 2, 4);
        for (int[] a : v)
            System.out.println(Arrays.toString(a));
    }

    /**
     * Input: numRows = 5
     * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
     */
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> currentArray = new ArrayList<>();
            if (result.size() != 0) {
                List<Integer> previousArray = result.get(i - 1);
                int sum = 0;
                for (int value : previousArray) {
                    sum += value;
                    currentArray.add(sum);
                    sum = value;
                }
                currentArray.add(1);

            } else {
                currentArray.add(1);
            }
            result.add(currentArray);
        }
        return result;
    }


    /**
     * Input: mat = [[1,2],[3,4]], r = 1, c = 4
     * Output: [[1,2,3,4]]
     * <p>
     * Input: mat = [[1,2],[3,4]], r = 2, c = 4
     * Output: [[1,2],[3,4]]
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {

        int givenArrayLength = mat.length;
        if (givenArrayLength != 0) {
            int columns = mat[0].length;
            if (givenArrayLength * columns != r * c) return mat;
        }

        int[][] res = new int[r][c];
        List<Integer> load = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                load.add(mat[i][j]);
            }
        }
        int currentElement = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = load.get(currentElement);
                currentElement++;
            }
        }
        return res;
    }

}
