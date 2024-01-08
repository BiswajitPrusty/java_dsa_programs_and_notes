package questions.matrix;



public class RowWithMaximumOnes {

    public int[] rowAndMaximumOnes(int[][] mat) {

        int[] answer = new int[2];
        int maxCount = Integer.MIN_VALUE;
        for (int i = mat.length - 1; i >= 0; i--) {
            int count = 0;
            for (int j = mat[i].length - 1; j >= 0; j--) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }
            if (maxCount <= count) {
                answer[0] = i;
                answer[1] = count;
                maxCount = count;
            }
        }
        return answer;
    }

}
