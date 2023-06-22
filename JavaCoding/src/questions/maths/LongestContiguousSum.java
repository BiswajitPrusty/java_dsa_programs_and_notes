package questions.maths;

public class LongestContiguousSum {

    public int longestContiguousSum(int[] a) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if(max < sum) max = sum;
            if(sum < 0) sum = 0;
        }
        return max;
    }

}
