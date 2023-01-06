package LeetCode;

import java.util.*;

public class EasyQuestions {
    public static void main(String[] args) {
        EasyQuestions e = new EasyQuestions();

        ListNode l = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l12 = new ListNode(2);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);

        l.next = l1;
        l1.next = l12;
        l12.next = l2;
        l2.next = l3;
    }

    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int arrow = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                arrow++;
                end = points[i][1];
            }
        }

        return arrow;
    }

    public int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> list = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String val = strs[i];
            char[] sorted = val.toCharArray();
            Arrays.sort(sorted);
            String key = new String(sorted);

            if (list.containsKey(key)) {
                List<String> strings = list.get(key);
                strings.add(val);
                list.put(key, strings);

            } else {
                List<String> newVal = new ArrayList<>();
                newVal.add(val);
                list.put(key, newVal);
            }
        }
        List<List<String>> result = new ArrayList<>();
        list.values().forEach(lis -> result.add(lis));
        return result;
    }

    public int[][] gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        // Create a copy of the original board
        int[][] copy = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = board[i][j];
            }
        }

        // Iterate through every cell in the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Count the number of live neighbors of cell (i, j)
                int liveNeighbors = countLiveNeighbors(copy, i, j);

                // Apply the rules to determine the next state of cell (i, j)
                if (copy[i][j] == 1) {
                    // Rule 1 and 3
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[i][j] = 0;
                    }
                    // Rule 2
                    else if (liveNeighbors == 2 || liveNeighbors == 3) {
                        board[i][j] = 1;
                    }
                } else {
                    // Rule 4
                    if (liveNeighbors == 3) {
                        board[i][j] = 1;
                    }
                }
            }
        }

        return board;
    }

    // Helper function that counts the number of live neighbors of cell (row, col)
    public int countLiveNeighbors(int[][] board, int row, int col) {
        int count = 0;
        int m = board.length;
        int n = board[0].length;

        // Check the top-left neighbor
        if (row > 0 && col > 0 && board[row - 1][col - 1] == 1) {
            count++;
        }
        // Check the top neighbor
        if (row > 0 && board[row - 1][col] == 1) {
            count++;
        }
        // Check the top-right neighbor
        if (row > 0 && col < n - 1 && board[row - 1][col + 1] == 1) {
            count++;
        }
        // Check the left neighbor
        if (col > 0 && board[row][col - 1] == 1) count++;

        // check the right neighbor
        if (col < n - 1 && board[row][col + 1] == 1) count++;

        // check the bottom-left neighbor
        if (row < m - 1 && col > 0 && board[row + 1][col - 1] == 1) count++;

        //check the bottom neighbor
        if (row < m - 1 && board[row + 1][col] == 1) count++;

        //check the bottom-right neighbor
        if (row < m - 1 && col < n - 1 && board[row + 1][col + 1] == 1) count++;

        return count;

    }

    /*
    The idea was firstly transpose the matrix and then flip it symmetrically. For instance,
    1  2  3
    4  5  6
    7  8  9
    after transpose, it will be swap(matrix[i][j], matrix[j][i])
    1  4  7
    2  5  8
    3  6  9
    Then flip the matrix horizontally. (swap(matrix[i][j], matrix[i][matrix.length-1-j])
    7  4  1
    8  5  2
    9  6  3
     */
    public void rotate(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            int temp = matrix[i][0];
            matrix[i][0] = matrix[i][matrix[0].length - 1];
            matrix[i][matrix[0].length - 1] = temp;
        }
        for (int[] a : matrix) {
            System.out.println(Arrays.toString(a));
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();

        backTrack(subset, new ArrayList<>(), nums, 0);
        return subset;
    }

    public void backTrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backTrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public int reverseBits(int n) {
        if (n == 0) return n;

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            if ((n & 1) == 1) result++;
            n >>= 1;
        }
        return result;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp, prev;
        prev = slow;
        slow = slow.next;
        prev.next = null;
        while (slow != null) {
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        slow = prev;
        fast = head;
        while (slow != null && fast != null) {
            if (slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    /*
    Given an integer n, return true if it is a power of three. Otherwise, return false.
    An integer n is a power of three, if there exists an integer x such that n == 3x.
    Example 1:
    Input: n = 27
    Output: true
    Explanation: 27 = 33
     */
    public boolean isPowerOfThree(int n) {
        while (n > 1 && n % 3 == 0) n /= 3;
        return n == 1;
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> permutations = new ArrayList<>();
        generatePermutations(permutations, new ArrayList<>(), nums);
        return permutations;
    }

    /*
    Permutations: [1,2,3] tempList of backtracking solution displayed here:,
    Before removal: 1, Before removal: 1 2, Before removal: 1 2 3, After removal: 1 2, After removal: 1, Before removal: 1 3, Before removal: 1 3 2, After removal: 1 3, After removal: 1, After removal:,
    Before removal: 2, Before removal: 2 1, Before removal: 2 1 3, After removal: 2 1, After removal: 2, Before removal: 2 3, Before removal: 2 3 1, After removal: 2 3, After removal: 2, After removal:,
    Before removal: 3, Before removal: 3 1, Before removal: 3 1 2, After removal: 3 1, After removal: 3, Before removal: 3 2, Before removal: 3 2 1, After removal: 3 2, After removal: 3, After removal:
     */
    public void generatePermutations(List<List<Integer>> permutations, List<Integer> currentPermutation,
                                     int[] nums) {
        if (currentPermutation.size() == nums.length) {
            permutations.add(new ArrayList<>(currentPermutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (currentPermutation.contains(nums[i]))
                continue;
            currentPermutation.add(nums[i]);
            generatePermutations(permutations, currentPermutation, nums);
            currentPermutation.remove(currentPermutation.size() - 1);
        }
    }

    public void deleteNode(ListNode node) {
        ListNode temp = node;
        ListNode prev = temp;
        while (temp.next != null) {
            temp.val = temp.next.val;
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
    }

    public boolean isPalindrome(String s) {

        String check = "";
        String reverse = "";
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            if ('a' <= s.charAt(i) && s.charAt(i) <= 'z') {
                check = s.charAt(i) + check;
                reverse = reverse + s.charAt(i);
            }
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                check = s.charAt(i) + check;
                reverse = reverse + s.charAt(i);
            }

        }
        return reverse.equalsIgnoreCase(check);
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] a = new int[digits.length + 1];
        a[0] = 1;
        return a;
    }

    public int[] getConcatenation(int[] nums) {
        int ans[] = new int[nums.length * 2];

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            ans[i] = nums[i];
            ans[length + i] = nums[i];
        }
        return ans;
    }

    public int[] buildArray(int[] nums) {

        int ans[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {

            ans[i] = nums[nums[i]];
        }
        return ans;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lenA = length(headA), lenB = length(headB);
        // move headA and headB to the same start point
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }
        // find the intersection until end
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int length(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }

    /*
    Input: n = 19
    Output: true
    Explanation:
    12 + 92 = 82
    82 + 22 = 68
    62 + 82 = 100
    12 + 02 + 02 = 1
     */
    public boolean isHappy(int n) {

        Set<Integer> checkNumber = new HashSet<>();
        int result = 0;
        while (checkNumber.add(n)) {
            result = 0;
            while (n >= 1) {
                int lastNumber = n % 10;
                result += lastNumber * lastNumber;
                n = n / 10;
            }
            if (result == 1) return true;
            else n = result;

        }
        return false;
    }

    /*
    For example:
    A -> 1
    B -> 2
    C -> 3
    
    Z -> 26
    AA -> 27
    AB -> 28 
     */
    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            result *= 26;
            result += columnTitle.charAt(i) - 'A' + 1;
        }
        return result;
    }

    /**
     * Input: nums = [1,1,2]
     * Output: 2, nums = [1,2,_]
     * Explanation: Your function should return k = 2, with the first two elements of nums being
     * 1 and 2 respectively.
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     */
    public int removeDuplicates(int[] nums) {

        int i = 0;
        for (int n : nums) {
            if (i == 0 || n > nums[i - 1]) {
                nums[i++] = n;
            }
        }
        return i;
    }

    /*
            Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
            The returned integer should be non-negative as well.
            Input: x = 4
            Output: 2
            Explanation: The square root of 4 is 2, so we return 2.
     */
    public int mySqrt(int x) {

        if (x == 0) return 0;
        int start = 1, end = x;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1))// Found the result
                return mid;
            else if (mid > x / mid)// Keep checking the left part
                end = mid;
            else
                start = mid + 1;// Keep checking the right part
        }
        return start;
    }

    /*
    Write a function to find the longest common prefix string amongst an array of strings.
    If there is no common prefix, return an empty string "".
    Example 1:
    Input: strs = ["flower","flow","flight"]
    Output: "fl"
     */
    public String longestCommonPrefix(String[] strs) {

        // Edge case: if the input array is null or empty, return an empty string
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Take the first string as the reference prefix
        String prefix = strs[0];

        // Iterate through the characters in the prefix
        for (int i = 0; i < prefix.length(); i++) {
            // Get the character at the current index
            char c = prefix.charAt(i);
            // Iterate through the strings
            for (int j = 1; j < strs.length; j++) {
                // If the character at the current index is not the same in one of the strings,
                // or the current string is shorter than the prefix, return the result obtained so far
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return prefix.substring(0, i);
                }
            }
        }

        // If all the characters in the prefix are the same in all the strings, return the prefix
        return prefix;
    }

    /*
    Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
    Note that you must do this in-place without making a copy of the array.

    Example 1:
    Input: nums = [0,1,0,3,12]
    Output: [1,3,12,0,0]
     */
    public void moveZeroes(int[] nums) {
        /*
        iterate over array put the non-zero numbers to the front index and increment the index to put all zeros
        from the point where index ends in the first loop.
         */
        int index = 0;
        for (int num : nums)
            if (num != 0)
                nums[index++] = num;
        for (int i = index; i < nums.length; i++)
            nums[i] = 0;
        for (int i : nums)
            System.out.println(i);
    }


    /*
    Input: nums = [3,0,1]
    Output: 2
    Explanation: n = 3 since there are 3 numbers,
    so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
     */
    public int missingNumber(int[] nums) {

        int sum = 0;
        for (int num : nums)
            sum += num;

        return (nums.length * (nums.length + 1)) / 2 - sum;
    }

    /**
     * using Moore's voting algorithm
     * This can be solved by Moore's voting algorithm. Basic idea of the algorithm is if we cancel out each
     * occurrence of an element e with all the other elements that are different from e then e will exist till end
     * if it is a majority element. Below code loops through each element and maintains a count of the element that
     * has the potential of being the majority element. If next element is same then increments the count,
     * otherwise decrements the count. If the count reaches 0 then update the potential index to the current element and sets count to 1.
     */
    public int majorityElement(int[] num) {

        int majorityIndex = 0;
        for (int count = 1, i = 1; i < num.length; i++) {
            int i1 = num[majorityIndex] == num[i] ? count++ : count--;
            if (count == 0) {
                majorityIndex = i;
                count = 1;
            }
        }

        return num[majorityIndex];
    }

    /**
     * Input: n = 00000000000000000000000000001011
     * Output: 3
     * Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
     */
    /**
     * a	b	a & b
     * 0	0	0
     * 0	1	0
     * 1	0	0
     * 1	1	1
     * Let's take a look at the bitwise AND operation of two integers 12 and 25.
     * 12 = 00001100 (In Binary)
     * 25 = 00011001 (In Binary)
     * // Bitwise AND Operation of 12 and 25
     * 00001100
     * & 00011001
     * ____________
     * 00001000 = 8 (In Decimal)
     */

    public int hammingWeight(int n) {

        int counter = 0;
        while (n != 0) {
            counter = counter + (n & 1);

            n = n >>> 1;
        }
        return counter;
    }

    /**
     * Given an integer n, return a string array answer (1-indexed) where:
     * answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
     * answer[i] == "Fizz" if i is divisible by 3.
     * answer[i] == "Buzz" if i is divisible by 5.
     * answer[i] == i (as a string) if none of the above conditions are true.
     * Example 1:
     * Input: n = 3
     * Output: ["1","2","Fizz"]
     */
    public List<String> fizzBuzz(int n) {

        List<String> answer = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                answer.add("FizzBuzz");
            } else if (i % 3 == 0) {
                answer.add("Fizz");
            } else if (i % 5 == 0) {
                answer.add("Buzz");
            } else {
                answer.add(i + "");
            }
        }
        return answer;
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        return insertToBst(nums, 0, nums.length - 1);
    }

    public TreeNode insertToBst(int[] nums, int l, int r) {

        if (l > r) {
            return null;
        }
        //choose the middle element and
        int mid = l + (r - l) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = insertToBst(nums, l, mid - 1);
        node.right = insertToBst(nums, mid + 1, r);
        return node;

    }

    public int singleNumber(int[] nums) {

        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            Integer counter = count.get(nums[i]);
            if (counter != null && counter == 2) {
                count.remove(nums[i]);
            }
        }
        Object o = count.keySet().toArray()[0];
        return (Integer) o;
    }

    public int maxDepth(TreeNode root) {
        // base case: if the root is null, the maximum depth is 0
        if (root == null) {
            return 0;
        }

        // compute the maximum depth of the left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // return the maximum of the two depths, plus 1 for the current node
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public void reverseString(char[] s) {

        int i = 0, j = s.length - 1;
        while (i <= j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public int romanToInt(String s) {
        int ans = 0;
        HashMap<Character, Integer> romanToInt = new HashMap<>();
        romanToInt.put('I', 1);
        romanToInt.put('V', 5);
        romanToInt.put('X', 10);
        romanToInt.put('L', 50);
        romanToInt.put('C', 100);
        romanToInt.put('D', 500);
        romanToInt.put('M', 1000);


        int nums[] = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            nums[i] = romanToInt.get(s.charAt(i));
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                ans -= nums[i];
            } else
                ans += nums[i];
        }
        return ans + nums[nums.length - 1];
    }
}
