package codingWithFolks;

public class Day13 {

    public static void main(String[] args) {

        int[] expectedNums = {1, 1, 2};

        System.out.println(removeDuplicates(expectedNums));
        for (int a : expectedNums) {
            System.out.print(a + ", ");
        }
        System.out.println();
    }

    public static void problem() {

    }

    public static int removeDuplicates(int[] nums) {

        int k = 0;
        int[] expectedNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count == 1) {
                expectedNums[k] = nums[i];
                k++;
            }

        }

        for (int i = 0; i < expectedNums.length; i++) {
            nums[i] = expectedNums[i];
        }
        return k;
    }
}
