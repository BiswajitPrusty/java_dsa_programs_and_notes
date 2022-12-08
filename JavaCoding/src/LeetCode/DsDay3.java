package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

public class DsDay3 {

    public static void main(String[] args) {

        DsDay3 d = new DsDay3();
        int nums1[] = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        var a = d.intersect(nums1, nums2);

        System.out.println(d.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));

    }

    /**
     * Given two integer arrays nums1 and nums2, return an array of their intersection.
     * Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
     * Example 1:
     * Input: nums1 = [1,2,2,1], nums2 = [2,2]
     * Output: [2,2]
     * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * Output: [4,9]
     */
    public int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i]))
                map.put(nums1[i], map.get(nums1[i]) + 1);
            else
                map.put(nums1[i], 1);

        }

        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                result.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }
        int[] r = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }
        return r;
    }

    /**
     * You are given an array prices where prices[i] is the price of a given stock on the ith day.
     * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
     * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
     * <p>
     * Example 1:
     * Input: prices = [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
     */

    public int maxProfit(int[] prices) {
        int overallProfit = 0;
        int profitIfSoldToday = 0;
        int leastSoFar = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (leastSoFar > prices[i]) {
                leastSoFar = prices[i];
            }

            profitIfSoldToday = prices[i] - leastSoFar;

            if (overallProfit < profitIfSoldToday) {
                overallProfit = profitIfSoldToday;
            }
        }

        return overallProfit;
    }
}
