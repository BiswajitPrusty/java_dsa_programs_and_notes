package questions.searching;

public class FindFirstAndLastPositionElementSortedArray34 {

    public int[] searchRange(int[] nums, int target) {
        return new int[]{firstPosition(nums, target), lastPosition(nums, target)};
    }

    public int firstPosition(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid] != nums[mid - 1]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    public int lastPosition(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid] != nums[mid + 1]) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }

        return -1;
    }
}
