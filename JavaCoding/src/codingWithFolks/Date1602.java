package codingWithFolks;

public class Date1602 {

    public static void main(String[] args) {
        Date1602 d = new Date1602();
        int a[] = {1, 3};
        System.out.println(d.searchInsert2(a, 2));
    }
    public int searchInsert2(int[] nums, int target) {

        if(target == 0)
            return 0;

        int l = 0, r = nums.length - 1;
        int m =0;
        while (l <= r) {
             m = l + (r - l) / 2;
            if (nums[m] == target)
                return m;
            if (nums[m] < target)
                l = m + 1;
            else
                r = m - 1;
        }

        return m + 1;

    }

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target)
                return i;
            if(nums[i] > target)
                return i;
        }
        return nums.length;
    }
}
