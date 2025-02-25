package dsa.topkelements;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentElements347 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> frequentElements = map.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .limit(k)
                .map(kv -> kv.getKey())
                .collect(Collectors.toList());
        int[] ans = new int[frequentElements.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = frequentElements.get(i);

        }
        return ans;

    }

    public static void main(String[] args) {
        String input = "This is a test string with=in it.";

        // Check if the string contains the '=' character
        boolean containsEquals = input.matches(".*=.*");

        if (containsEquals) {
            System.out.println("The string contains '='.");
        } else {
            System.out.println("The string does not contain '='.");
        }
    }
}
