package dsa.prefixsum;

import java.util.HashMap;

public class ContiguousArray525 {

    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLength = 0, prefix = 0;
        for(int i = 0; i < nums.length; i++){
            prefix += nums[i] == 0 ? -1 : 1;

            if(map.containsKey(prefix)){
                maxLength= Math.max(maxLength, i - map.get(prefix));
            }else{
                map.put(prefix, i);
            }
        }

        return maxLength;
    }
}
