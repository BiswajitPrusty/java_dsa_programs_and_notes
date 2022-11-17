package SortingAlgo;

public class HeapSort {

    public static void main(String[] args) {
        int a[] = {3, 2, 5, 1, 6, 4, 9, 0, 8};
        HeapSort hs = new HeapSort();
        hs.sort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public void sort(int a[]) {
        int len = a.length;
        for (int i = len / 2 - 1; i >= 0; i--) {

            heapSort(a, len, i);
        }
        for (int i = len - 1; i >= 0; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            heapSort(a, i, 0);
        }
    }

    public void heapSort(int a[], int al, int pi) {
        int largest = pi;
        int li = 2 * pi + 1;
        int ri = 2 * pi + 2;
        if (li < al && a[li] > a[largest]) {
            largest = li;
        }

        if (ri < al && a[ri] > a[largest]) {
            largest = ri;
        }

        if (largest != pi) {
            int temp = a[largest];
            a[largest] = a[pi];
            a[pi] = temp;
            heapSort(a, al, largest);
        }
    }
}
