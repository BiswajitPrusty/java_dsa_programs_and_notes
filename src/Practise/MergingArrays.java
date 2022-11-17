package Practise;

public class MergingArrays {
    //creating a sorted array by considering 2 arrays value
    public static void main(String[] args) {
        long a[] = {1, 3, 5, 7};
        long b[] = {0, 2, 6, 8, 9};
        myMerge(a, b, a.length, b.length);

    }

    //function to find next gap
    public static int nextGap(int gap) {

        //It returns the ceil value of gap/2 or 0 if gap is 1.
        if (gap <= 1) return 0;
        return (gap / 2) + (gap % 2);
    }

    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) {
        int i, j, gap = n + m;//4+5
        long tmp;
        //      5
        for (gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {

            //Comparing elements in the first array itself with difference in
            //index equal to the value of gap.
            for (i = 0; i + gap < n; i++) {
                if (arr1[i] > arr1[i + gap]) {

                    //If element at ith index is greater than element at
                    //(i+gap)th index, we swap them.
                    tmp = arr1[i];
                    arr1[i] = arr1[i + gap];
                    arr1[i + gap] = tmp;
                }
            }

            //Now comparing elements in both arrays with help of two pointers.
            //The loop stops whenever any pointer exceeds the size of its array
            for (j = gap > n ? gap - n : 0; i < n && j < m; i++, j++) {

                //If element in the first array is greater than element in
                //second array, we swap them.
                if (arr1[i] > arr2[j]) {
                    tmp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = tmp;
                }
            }

            if (j < m) {
                //At last, comparing elements in the second array itself with
                //difference in index equal to the value of gap.
                for (j = 0; j + gap < m; j++) {

                    //If element at jth index is greater than element at
                    //(j+gap)th index, we swap them.
                    if (arr2[j] > arr2[j + gap]) {
                        tmp = arr2[j];
                        arr2[j] = arr2[j + gap];
                        arr2[j + gap] = tmp;
                    }
                }
            }
        }
    }

    public static void myMerge(long arr1[], long arr2[], int n, int m) {
        long a[] = new long[n + m];
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                a[k++] = arr1[i++];
            } else {
                a[k++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            a[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            a[k++] = arr2[j++];
        }
        int f = 0;
        for (f = 0; f < arr1.length; f++)
            arr1[f] = a[f];

        for (int g =0; g<arr2.length;g++)
            arr2[g] =a[f++];

            for (long value : arr2)
                System.out.print(value + " ");
    }
}
