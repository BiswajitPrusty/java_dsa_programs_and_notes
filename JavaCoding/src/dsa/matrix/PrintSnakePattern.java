package dsa.matrix;

public class PrintSnakePattern {

    public static void main(String[] args) {
        printMatrixSnakePattern(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
    }

    public static void printMatrixSnakePattern(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j]+",");
                }
            } else {
                for (int k = arr[i].length - 1; k >= 0; k--) {
                    System.out.print(arr[i][k]+",");
                }
            }
            System.out.println();
        }
    }
}
