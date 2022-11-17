package Practise;

public class MaxMinElementArranging {
//    Input:
//    N = 6
//    arr[] = {1,2,3,4,5,6}   1,2,3,4-> 4,1,3,2
//    Output: 6 1 5 2 4 3
//    Explanation: j element = 6, min = 1,
//    second j = 5, second min = 2, and
//    so on... Modified array is : 6 1 5 2 4 3.

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        rearrange(arr, arr.length);
    }

    public static void online(int arr[], int n) {
//        int arr[] = {1,2,3,4,5,6};

        //Initialising index of first minimum and first maximum element.
        int max_idx = n - 1, min_idx = 0;

        //Storing maximum element of array.
        int max_elem = arr[n - 1] + 1;

        for (int i = 0; i < n; i++) {

            //At even index, we have to put maximum elements in decreasing order.
            if (i % 2 == 0) {
                arr[i] += (arr[max_idx] % max_elem) * max_elem;
                //Updating maximum index.
                max_idx--;
            }

            //At odd index, we have to put minimum elements in increasing order.
            else {
                arr[i] += (arr[min_idx] % max_elem) * max_elem;
                //Updating minimum index.
                min_idx++;
            }
        }

        //Dividing array elements by maximum element to get the result.
        for (int i = 0; i < n; i++)
            arr[i] = arr[i] / max_elem;

    }

    public static void rearrange(int a[], int n) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (i % 2 == 0) {
                for (int j = i; j < a.length; j++) {
                    if (a[j] > max) {
                        max = a[j];
                        a[j] = a[i];
                        a[i] = max;
                    }
                }
                max = Integer.MIN_VALUE;
            } else {
                for (int j = i; j < a.length; j++) {
                    if (a[j] < min) {
                        min = a[j];
                        a[j] = a[i];
                        a[i] = min;
                    }
                }

                min = Integer.MAX_VALUE;
            }

        }

        for (int i : a)
            System.out.print(i + " ");

    }
}
