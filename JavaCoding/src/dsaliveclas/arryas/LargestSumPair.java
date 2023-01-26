package dsaliveclas.arryas;

public class LargestSumPair {
    public int[] largestContiguous(int a[]) {
        int ans = Integer.MIN_VALUE;
        int pairIndex[] = new int[2];
        for (int i = 0; i < a.length - 1; i++) {
            int sum = a[i] + a[i + 1];
            if (sum > ans) {
                pairIndex[0] = i;
                pairIndex[1] = i + 1;
                ans = sum;
            }
        }
        return pairIndex;
    }
}
