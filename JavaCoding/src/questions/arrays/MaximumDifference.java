package questions.arrays;

public class MaximumDifference {

    public static void main(String[] args) {
        System.out.println(maxDiff(new int[]{2, 3, 10, 6, 4, 8, 1}));
    }

    static int maxDiff(int[] arr) {
        int res = arr[1] - arr[0];

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                res = Math.max(res, arr[j] - arr[i]);
            }

        }
        return res;
    }
}
