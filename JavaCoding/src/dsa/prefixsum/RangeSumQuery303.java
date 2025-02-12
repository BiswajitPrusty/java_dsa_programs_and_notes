package dsa.prefixsum;

public class RangeSumQuery303 {

    private int[] prefixSum;
    public RangeSumQuery303(int[] nums) {
        prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
    }
    public int sumRange(int left, int right) {
        return left == 0 ? prefixSum[right] : prefixSum[right] - prefixSum[left - 1];
    }

    public static void main(String[] args) {
        RangeSumQuery303 r = new RangeSumQuery303(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(r.sumRange(0, 2));
    }
}
