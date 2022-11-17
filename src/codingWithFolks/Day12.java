package codingWithFolks;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Day12 {

    public static void main(String[] args) {
        int nums[] = {1, 1, 1, 2, 2, 3};
        topKFrequent(nums, 2);
    }

    public static int[] topKFrequent(int[] nums, int k) {

        ArrayList<Integer> respone = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }

            }
            if (count >= k) {
                respone.add(nums[i]);
            }
        }

        respone = (ArrayList<Integer>) respone.stream().distinct().collect(Collectors.toList());
        int result[] = new int[respone.size()];
        for (int i = 0; i < respone.size(); i++) {
            result[i] = respone.get(i);

        }
        System.out.println(respone);
        return result;

    }


}
