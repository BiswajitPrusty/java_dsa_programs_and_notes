package questions.searching;

public class RoatedSortedArray2 {

    public static void main(String[] args) {
        search(new int[]{1, 0, 1, 1, 1}, 0);
    }

    //
    public boolean searchWithAllCornerCase(int[] nums, int target) {
        int low = 0 , high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target) return true;

            if((nums[low] == nums[mid]) && (nums[high] == nums[mid]))
            {
                low++;
                high--;
            }
            else if(nums[mid] >= nums[low]){
                if(target >= nums[low] && target < nums[mid]) high = mid - 1;
                else low = mid + 1;
            }
            else {
                if(target <= nums[high] && target > nums[mid]) low = mid + 1;
                else high = mid - 1;
            }
        }

        return false;
    }
    //few corner cases missed in my approach
    public static boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return true;

            if (nums[mid] >= nums[low]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            if (nums[mid] <= nums[high]) {
                if (target <= nums[high] && target > nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }
}
