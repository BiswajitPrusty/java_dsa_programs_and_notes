package Practise;

public class Date1812 {

    public static void main(String[] args) {
        int a[] = {9, 2, 1, 3, 4, 8, 5, 7, 6};

        Date1812 d = new Date1812();
        d.mergeSort(a);

        for (int i : a) {
            System.out.print(i + " ");
        }
    }


    int arey[];
    int temp[];

    public void mergeSort(int a[]) {
        System.out.println("merge Sort");
        this.arey = a;
        temp = new int[a.length];

        divide(0, a.length - 1);

    }

    private void divide(int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            divide(low, mid);
            divide(mid + 1, high);
            merge(low, mid, high);
        }

    }

    private void merge(int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            temp[i] = arey[i];
        }
        int i = low, j = mid + 1, k = low;
        while (i <= mid && j <= high) {
            if (temp[i] <= temp[j]) {
                arey[k++] = temp[i++];
            } else {
                arey[k++] = temp[j++];
            }
        }

        while (i <= mid) {
            arey[k++] = temp[i++];
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

    public void insertion(int a[]) {
        System.out.println("insertion sort");
        for (int i = 1; i < a.length; i++) {
            int j = i, temp = a[i];
            while (j > 0 && a[j - 1] > temp) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = temp;
        }
    }

    public void bubbleSort(int a[]) {

        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length - i - 1; i++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j] = temp;
                }
            }
        }
    }
}
