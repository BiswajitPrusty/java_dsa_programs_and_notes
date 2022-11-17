package Practise;

import java.util.Arrays;

public class Date0309 {
    int arey[];
    int temp[];

    public static void main(String[] args) {

        int a[] = {9, 1, 3, 2, 6, 4, 7, 5, 8};
        Date0309 d = new Date0309();
//        d.bubble(a);
//        d.selection(a);
//        d.insertion(a);
//        d.mergeSort(a);
        d.heapify(a);
//        d.quickSort(a, 0, a.length - 1);
        d.printArray(a);
    }

    public void heapify(int a[]) {
        int len = a.length;
        for (int i = len / 2 - 1; i >= 0; i--) {

            heapsort(a, i, len);
        }
        for (int i = len - 1; i > -0; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            heapsort(a, 0, i);
        }
    }

    void heapsort(int a[], int pni, int arrayLength) {
        int large = pni;
        int ln = 2 * pni + 1;
        int rn = 2 * pni + 2;

        if (ln < arrayLength && a[ln] > a[large]) {
            large = ln;
        }
        if (rn < arrayLength && a[rn] > a[large]) {
            large = rn;
        }

        if (large != pni) {
            int temp = a[large];
            a[large] = a[pni];
            a[pni] = temp;
            heapsort(a, large, arrayLength);
        }

    }

    public void quickSort(int a[], int low, int high) {
        int p = quickLogic(a, low, high);
        if (low < p - 1) {
            quickSort(a, low, p - 1);
        }
        if (high > p)
            quickSort(a, p, high);

    }

    public int quickLogic(int a[], int low, int high) {
        int mid = a[(low + high) / 2];
        while (low <= high) {
            while (a[low] < mid) {
                low++;
            }
            while (a[high] > mid)
                high--;
            if (low <= high) {
                int temp = a[low];
                a[low] = a[high];
                a[high] = temp;
                low++;
                high--;
            }
        }
        return low;
    }


    public void mergeSort(int a[]) {
        this.arey = a;
        this.temp = new int[a.length];
        divide(0, a.length - 1);
    }


    public void merging(int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            temp[i] = arey[i];
        }
        int i = low, j = mid + 1, k = low;
        while (i <= mid && j <= high) {
            if (temp[i] < temp[j]) {
                arey[k++] = temp[i++];
            } else {
                arey[k++] = temp[j++];
            }
        }
        while (i <= mid) {
            arey[k++] = temp[i++];

        }

    }

    public void divide(int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            divide(low, mid);
            divide(mid + 1, high);
            merging(low, mid, high);
        }
    }


    public void insertion(int a[]) {
        for (int i = 1; i < a.length; i++) {
            int j = i;
            int temp = a[i];
            while (j > 0 && temp < a[j - 1]) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = temp;
        }
    }

    public void selection(int a[]) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }

            }
            int temp = a[min];
            a[min] = a[i];
            a[i] = temp;

        }
    }

    public void bubble(int a[]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }

            }

        }
    }


    public void printArray(int a[]) {
        for (int i : a)
            System.out.print(i + ", ");
    }
}
