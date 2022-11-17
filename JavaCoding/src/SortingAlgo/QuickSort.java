package SortingAlgo;

public class QuickSort {

    public static void main(String[] args) {
        int a[] = {2, 1, 4, 3, 9, 5, 7, 8, 6};
        QuickSort q = new QuickSort();
        q.quickRecursion(a, 0, a.length - 1);
        for (int i : a) {
            System.out.print(i + ", ");
        }
    }

    public void quickRecursion(int a[], int low, int high) {
        int p = divide(a, low, high);
        if (low < p - 1) {
            quickRecursion(a, low, p - 1);
        }
        if (high > p) {
            quickRecursion(a, p, high);
        }
    }

    public int divide(int a[], int low, int high) {
        int pi = a[(low + high) / 2];
        while (low <= high) {
            while (a[low] < pi) {
                low++;
            }
            while (a[high] > pi) {
                high--;
            }
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
}
