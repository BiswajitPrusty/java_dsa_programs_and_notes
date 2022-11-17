package Practise;

public class Date1110 {
    int arey[];
    int tem[];

    public static void main(String[] args) {
        int a[] = {9, 1, 8, 2, 7, 4, 6, 3, 5, 0};
        Date1110 d = new Date1110();
        d.heapCall(a);
        for (int i : a)
            System.out.print(i + " ");
    }

    public void heapCall(int a[]) {
        int len = a.length - 1;
        for (int i = len / 2; i >= 0; i--) {
            heapSort(a, len, i);
        }
        for (int i = len; i >= 0; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            heapSort(a, i, 0);
        }
    }

    public void heapSort(int a[], int al, int pi) {
        int rn = 2 * pi + 2;
        int ln = 2 * pi + 1;
        int largest = pi;

        if (ln < al && a[ln] > a[largest]) {
            largest = ln;
        }

        if (rn < al && a[rn] > a[largest]) {
            largest = rn;
        }
        if (largest != pi) {
            int temp = a[largest];
            a[largest] = a[pi];
            a[pi] = temp;
            heapSort(a, al, largest);

        }
    }

    public void sorting(int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            tem[i] = arey[i];
        }
        int i = low, j = mid + 1, k = low;
        while (i <= mid && j <= high) {
            if (tem[i] <= tem[j]) {
                arey[k++] = tem[i++];
            } else {
                arey[k++] = tem[j++];
            }
        }

        while (i <= mid) {
            arey[k++] = tem[i++];
        }
    }

    public void divide(int low, int high) {

        if (low < high) {
            int mid = (low + high) / 2;
            divide(low, mid);
            divide(mid + 1, high);
            sorting(low, mid, high);
        }
    }

    public void mergeSort(int arey[]) {
        this.arey = arey;
        this.tem = new int[arey.length];
        divide(0, arey.length - 1);
    }
}
