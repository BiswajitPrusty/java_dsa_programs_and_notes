package codingWithFolks;

import java.util.Arrays;

public class Date1702 {

    public static void main(String[] args) {
        int a[] = {7, 7, 8, 8};
        System.out.println(majorityElement(a));
    }

    static public int majorityElement(int[] nums) {

        int ans = 0;
        //distinct element
        //a = [1,2,3]
        int a[] = Arrays.stream(nums).sorted().distinct().toArray();

        for (int i = 0; i < a.length; i++) {
            int count = 0;

//          num =[1,1,2,2,3,3,3,3,3]
            for (int j = 0; j < nums.length; j++) {

                if (a[i] == nums[j]) {
                    ans = a[i];
                    count++;
                }
                if (count > nums.length / 2) {
                    return ans;
                }

            }

        }

        return ans;
    }
}
