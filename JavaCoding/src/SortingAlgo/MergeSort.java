package SortingAlgo;

public class MergeSort {
    int length;
    int temp[];
    int arey[];

    public static void main(String[] args) {
        int a[] = {2, 1, 4, 3, 9, 5, 7, 8, 6};
        MergeSort m = new MergeSort();
        m.merge(a);
        for (int i : a) {
            System.out.print(i + ", ");
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

    public void merging(int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            temp[i] = arey[i];
        }
        int i = low, j = mid + 1, k = low;
        while (i <= mid && j <= high) {
            if (temp[i] <= temp[j]) {
                arey[k] = temp[i];
                i++;
            } else {
                arey[k] = temp[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            arey[k] = temp[i];
            i++;
            k++;
        }

    }

    public void merge(int a[]) {

        this.arey = a;
        this.length = a.length;
        temp = new int[this.length];
        divide(0, this.length - 1);
    }
}
