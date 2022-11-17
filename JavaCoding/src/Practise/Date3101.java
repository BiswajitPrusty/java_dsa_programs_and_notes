package Practise;

import java.util.ArrayList;
import java.util.HashSet;

public class Date3101 {

    public static void main(String[] args) {

        zeroToFive(100);

    }

    static void zeroToFive(int num) {

        int temp = 0;
        int result = 0;
        while (num > 0) {
            temp = num % 10;
            temp = temp == 0 ? 5 : temp;
            result = result * 10 + temp;
            num /= 10;
        }

        int ans = 0;
        while (result > 0) {
            temp = result % 10;
//            temp = temp == 0 ? 5 : temp;
            ans = ans * 10 + temp;
            result /= 10;
        }


        System.out.println(ans +" "+num);
    }

    static long[] productArray(int arr[], int n) {

        long[] prod = new long[n];
        // Base case
        if (n == 1) {
            prod[0] = 1;
            return prod;
        }

        long temp = 1;

        /* Initialize the product array as 1 */
        for (int i = 0; i < n; i++)
            prod[i] = 1;

		/* In this loop, temp variable contains product of
		elements on left side excluding arr[i] */
        for (int i = 0; i < n; i++) {
            prod[i] = temp;
            temp *= arr[i];
        }
        /* Initialize temp to 1 for product on right side */
        temp = 1;

		/* In this loop, temp variable contains product of
		elements on right side excluding arr[i] */
        for (int i = n - 1; i >= 0; i--) {
            prod[i] *= temp;
            temp *= arr[i];
        }
        return prod;
    }


    public static int NumberofElementsInIntersection(int a[], int b[], int n, int m) {
        int count = 0;

        HashSet<Integer> data = new HashSet<>();

        for (int i = 0; i < n; i++) {
            data.add(a[i]);
        }
        for (int i = 0; i < m; i++) {
            if (data.contains(b[i])) {
                count++;
                data.remove(b[i]);
            }
        }

        return count;
    }

    public static long[] productExceptSelf(int nums[], int n) {
        long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            ans[i] = 1;
            for (int j = 0; j < n; j++) {
                if (nums[i] != nums[j])
                    ans[i] *= nums[j];
            }
        }
        return ans;
    }

    static public long modfun(long n, long R) {
        // Base cases
        if (n == 0)
            return 0;
        // power zero mean answer is 1
        if (R == 0)
            return 1;
        // If R is even
        long y;
        if (R % 2 == 0) {
            // finding r/2 power as power is even then storing answer in y and
            // if power is even like 2^4 we can simply do (2^2)*(2^2)
            y = modfun(n, R / 2);
            y = (y * y) % 1000000007;
        }

        // If R is odd
        else {
            y = n % 1000000007;
            // reduce the power by 1 to make it even.
            // The reducing power by one can be done if we take one n out. Like 2^3 can be written as 2*(2^2)
            y = (y * modfun(n, R - 1) % 1000000007) % 1000000007;
        }
        // finally return the answer (y+mod)%mod = (y%mod+mod%mod)%mod = (y%mod)%mod
        return ((y + 1000000007) % 1000000007);
    }


    static long power(int N, int R) {
        return modfun(N, R) % 1000000007;

    }


    public int modInverse(int a, int m) {
        for (int i = 0; i < m; i++) {
            if ((i * a) % m == 1) {
                return i;
            }
        }
        return -1;
    }

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> list = new ArrayList<>();
        int in = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum >= s) {
                while (s < sum && in < i) {
                    sum -= arr[in++];
                }
                if (sum == s) {
                    list.add(in + 1);
                    list.add(i + 1);
                    return list;
                }
            }
        }
        list.add(-1);
        return list;
    }

    static ArrayList<Integer> subarraySm(int[] arr, int n, int s) {
        int start = 0;
        int last = 0;
        boolean flag = false;
        int currsum = 0;
        ArrayList<Integer> res = new ArrayList<Integer>();

        //iterating over the array.
        for (int i = 0; i < n; i++) {
            //storing sum upto current element.
            currsum += arr[i];

            //checking if current sum is greater than or equal to given number.
            if (currsum >= s) {
                last = i;
                //we start from starting index till current index and do the
                //excluding part while s(given number) < currsum.
                while (s < currsum && start < last) {
                    //subtracting the element from left i.e., arr[start]
                    currsum -= arr[start];
                    ++start;
                }

                //now if current sum becomes equal to given number, we store
                //the starting and ending index for the subarray.
                if (currsum == s) {
                    res.add(start + 1);
                    res.add(last + 1);

                    //flag is set to true since subarray exists.
                    flag = true;
                    break;
                }
            }
        }
        //if no subarray is found, we store -1 in result else the found indexes.
        if (flag == false) {
            res.add(-1);
        }
        //returning the result.
        return res;
    }
}
