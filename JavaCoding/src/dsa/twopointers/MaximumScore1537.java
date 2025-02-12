package dsa.twopointers;

public class MaximumScore1537 {

    /*

    Input: nums1 = [2,4,5,8,10],
           nums2 =   [4,6,8,9]
    Output: 30
    Explanation: Valid paths:
    [2,4,5,8,10], [2,4,5,8,9], [2,4,6,8,9], [2,4,6,8,10],  (starting from nums1)
    [4,6,8,9], [4,5,8,10], [4,5,8,9], [4,6,8,10]    (starting from nums2)
    The maximum is obtained with the path in green [2,4,6,8,10].
Explanation:
We use two pointers i and j to traverse nums1 and nums2, respectively.
Two sum accumulators, sum1 and sum2, track sums of elements before a common element is encountered.
When a common element appears:
We add the maximum of sum1 and sum2 (choosing the optimal path) to result.
Reset sum1 and sum2 and continue traversing both arrays.
After the loop, we add the maximum remaining sum from either array to result.
Finally, return result % (10^9 + 7) to handle large numbers.

Summary:
Two-pointer approach for efficiency.
Accumulate sum from both arrays, switching at intersections.
Take the maximum possible sum at each switch.
Modulo operation to handle overflow.
This approach runs in O(N + M) time, where N and M are the sizes of nums1 and nums2.
     */
        public int maxSum(int[] nums1, int[] nums2) {
            int MOD = 1_000_000_007;
            int i = 0, j = 0;
            long sum1 = 0, sum2 = 0, result = 0;

            while (i < nums1.length || j < nums2.length) {
                if (i < nums1.length && (j == nums2.length || nums1[i] < nums2[j])) {
                    sum1 += nums1[i++];
                } else if (j < nums2.length && (i == nums1.length || nums1[i] > nums2[j])) {
                    sum2 += nums2[j++];
                } else { // nums1[i] == nums2[j]
                    result += Math.max(sum1, sum2) + nums1[i];
                    sum1 = 0;
                    sum2 = 0;
                    i++;
                    j++;
                }
            }

            result += Math.max(sum1, sum2);
            return (int) (result % MOD);
        }

        public static void main(String[] args) {
            MaximumScore1537 sol = new MaximumScore1537();
            int[] nums1 = {2, 4, 5, 8, 10};
            int[] nums2 = {4, 6, 8, 9};
            System.out.println(sol.maxSum(nums1, nums2)); // Output: 30
        }

}
