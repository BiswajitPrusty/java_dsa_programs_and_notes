package dsa.matrix;

public class SerachInSortedMatrix {

    public static void main(String[] args) {
        searchInLinearTime(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}, 35);
    }

    private static void searchInLinearTime(int[][] mat, int target) {
        int y = 0, x = mat.length - 1;
        while (y <= x) {
            if (mat[y][x] == target) {
                System.out.println("Found at row: " + (y + 1) + " column: " + (x + 1));
                return;
            }
            if (mat[y][x] > target) {
                x--;
            }

            if (mat[y][x] < target) {
                y++;
            }
        }

        System.out.println("Not Found");
    }

    private static void searchMatrix(int[][] mat, int target) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == target) {
                    System.out.println("Found at row: " + (i + 1) + " column: " + (j + 1));
                    return;
                }
            }
        }
        System.out.println("Not Found");
    }
}
