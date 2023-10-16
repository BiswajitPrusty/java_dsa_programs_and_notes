package questions.arrays;

public class CountNumberParis2006 {

    public static void main(String[] args) {
        System.out.println(countKDifference(new int[]{1, 2, 2, 1}, 1));
    }

    public static int countKDifference(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {

            for (int j = i; j < nums.length; j++) {
                if (i != j && Integer.max(nums[i], nums[j]) - Integer.min(nums[i], nums[j]) == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
