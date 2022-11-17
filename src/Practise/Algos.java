package Practise;

public class Algos {

    static int arey[];
    static int tempArray[];

    public static void main(String[] args) {
        int[] a = {3, 1, 2, 8, 0, 9, 5, 4, 7, 6};

        quickSort(a, 0, a.length - 1);
        print(a);

    }

    public static void headSort(int a[]) {

        int len = a.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(a, len, i);
        }
        for (int i = len - 1; i > -0; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            heapify(a, i, 0);
        }
    }

    public static void heapify(int a[], int al, int pi) {
        int large = pi;
        int left = pi * 2 + 1;
        int right = pi * 2 + 2;
        if (al > left && a[left] > a[large]) {
            large = left;
        }
        if (al > right && a[right] > a[large])
            large = right;

        if (large != pi) {
            int temp = a[large];
            a[large] = a[pi];
            a[pi] = temp;
            heapify(a, al, large);
        }
    }

    public static void quickSort(int a[], int low, int high) {
        int pi = quick(a, low, high);

        if (low < pi - 1) {
            quickSort(a, low, pi - 1);
        }
        if (high > pi) {
            quickSort(a, pi, high);
        }
    }

    public static int quick(int a[], int low, int high) {
        int mid = a[(low + high) / 2];
        while (low <= high) {
            while (a[low] < mid) {
                low++;
            }

            while (a[high] > mid) {
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

    public static void merge(int a[]) {
        arey = a;
        tempArray = new int[a.length];
        dividing(0, a.length - 1);
    }

    private static void dividing(int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            dividing(low, mid);
            dividing(mid + 1, high);
            merging(low, mid, high);
        }
    }

    private static void merging(int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            tempArray[i] = arey[i];
        }

        int i = low, j = mid + 1, k = low;
        while (i <= mid && j <= high) {
            if (tempArray[i] < tempArray[j]) {
                arey[k++] = tempArray[i++];
            } else {
                arey[k++] = tempArray[j++];
            }
        }

        while (i <= mid) {
            arey[k++] = tempArray[i++];
        }
    }

    public static void inseration(int a[]) {
        for (int i = 1; i < a.length; i++) {
            int j = i, temp = a[i];
            while (j > 0 && a[j - 1] > temp) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = temp;

        }
    }

    public static void selection(int a[]) {

        for (int i = 0; i < a.length; i++) {
            int min = i, temp;
            for (int j = i; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }

    public static void bubble(int a[]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    public static void print(int a[]) {
        for (int i : a)
            System.out.print(i + " ");
    }
}
