package Practice;

public class AllAlogs {

    int length;
    int temp[];
    int array[];

    public static void main(String[] args) {

        AllAlogs algo = new AllAlogs();
        int a[] = {9, 1, 4, 3, 2, 6, 5, 8, 7};
        algo.mergeSort(a);

        printArray(a);

    }

    public static void printArray(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println();
    }

    public void quickSort(int a[], int low, int high) {

        int p = divideQuickSort(a, low, high);
        if (low < p - 1) {
            quickSort(a, low, p - 1);
        }
        if (high > p) {
            quickSort(a, p, high);
        }
    }

    public int divideQuickSort(int a[], int low, int high) {
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

    public void mergeSort(int a[]) {
        this.array = a;
        this.length = a.length;
        temp = new int[this.length];
        divideMergeSort(0, this.length - 1);
    }

    private void divideMergeSort(int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            divideMergeSort(low, mid);
            divideMergeSort(mid + 1, high);
            mergeSortLogic(low, mid, high);
        }
    }

    private void mergeSortLogic(int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            temp[i] = array[i];
        }
        int i = low, j = mid + 1, k = low;
        while (i <= mid && j <= high) {
            if (temp[i] <= temp[j]) {
                array[k++] = temp[i++];
            } else {
                array[k++] = temp[j++];
            }
        }
        while (i <= mid) {
            array[k++] = temp[i++];
        }
    }

    public void bubbleSort(int a[]) {

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

    public void selectionSort(int a[]) {

        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {

                if (a[j] < a[min]) {
                    min = j;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }

    public void insertionSort(int a[]) {
//        int a[] = {9, 1, 4, 3, 2, 6, 5, 8, 7};

        int temp, j;
        for (int i = 1; i < a.length; i++) {
            temp = a[i];
            j = i;

            while (j > 0 && temp < a[j - 1]) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = temp;
        }
    }

}
