package questions.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddToArrayFormOfInteger989 {
    public static void main(String[] args) {
        addToArrayForm(1,9,9,9,9,9,9,9,9,9,9);
    }

    /*
Intuition
Let's add numbers in a schoolbook way, column by column. For example, to add 123 and 912, we add 3+2, then 2+1,
then 1+9. Whenever our addition result is more than 10, we carry the 1 into the next column. The result is 1035.

Algorithm
We can do a variant of the above idea that is easier to implement - we put the entire addend in the first column from the right.
Continuing the example of 123 + 912, we start with [1, 2, 3+912]. Then we perform the addition 3+912, leaving 915.
 The 5 stays as the digit, while we 'carry' 910 into the next column which becomes 91.
We repeat this process with [1, 2+91, 5]. We have 93, where 3 stays and 90 is carried over as 9. Again,
 we have [1+9, 3, 5] which transforms into [1, 0, 3, 5].
     */
    public static List<Integer> addToArrayFormLeetCodeAns(int k, int... num) {
        List<Integer> ans = new ArrayList<>();
        int i = num.length;
        while (--i >= 0 || k > 0) {
            if (i >= 0) {
                k += num[i];
            }
            ans.add(k % 10);
            k /= 10;
        }
        Collections.reverse(ans);
        return ans;
    }

        //my approach
    public static List<Integer> addToArrayForm(int k, int... num) {

        int ans = 0;
        for (int i = 0; i < num.length; i++) {
            ans = ans * 10 + num[i];
        }
        ans += k;
        List<Integer> list = new ArrayList<>();
        while (ans > 0) {
            int lastNumber = ans % 10;
            ans /= 10;
            list.add(lastNumber);
        }
        Collections.reverse(list);
        return list;
    }
}
