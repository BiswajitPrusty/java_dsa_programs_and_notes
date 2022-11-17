package Practise;

import java.util.Arrays;

public class Date2201 {

    public static void main(String[] args) {

        int a[] = {3, 1, 2, 9, 5, 4, 7, 6, 0, 8};
        Date2201 d = new Date2201();
        d.merge(a);
        Arrays.stream(a).forEach(System.out::print);
    }


    int temp[];
    int arey[];

    public void mergeSort(int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            temp[i] = arey[i];
        }

        int i = low, j = mid + 1, k = low;

        while (i <= mid && j <= high) {
            if (temp[i] <= temp[j])
                arey[k++] = temp[i++];
            else
                arey[k++] = temp[j++];
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
            mergeSort(low, mid, high);

        }

    }

    public void merge(int a[]) {
        this.arey = a;
        this.temp = new int[a.length];
        divide(0, a.length - 1);
    }

}
