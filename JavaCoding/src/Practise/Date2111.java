package Practise;

public class Date2111 {

    int length;
    int temp[];
    int arey[];


    public static void main(String[] args) {
        int a[] = {9, 3, 1, 2, 4, 6, 5, 7, 0, 8};

        Date2111 d = new Date2111();
        d.heapCall(a);
        for (int i : a)
            System.out.print(i + ", ");
    }

    public void heapCall(int a[]) {
        int len = a.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            heap(a, len, i);
        }

        for (int i = len -1; i >= 0; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            heap(a, i, 0);
        }
    }

    public void heap(int a[], int al, int pi) {
        int large = pi;
        int ln = 2 * pi + 1;
        int rn = 2 * pi + 2;

        if (ln < al && a[ln] > a[large]) {
            large = ln;
        }
        if (rn < al && a[rn] > a[large]) {
            large = rn;
        }
        if (large != pi) {
            int temp = a[large];
            a[large] = a[pi];
            a[pi] = temp;
            heap(a, al, large);
        }
    }


    public void quick(int a[], int low, int high) {
        int pi = quickDiv(a, low, high);
        if (low < pi - 1) {
            quick(a, low, pi - 1);
        }
        if (high > pi) {
            quick(a, pi, high);
        }

    }

    public int quickDiv(int a[], int low, int high) {
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

    public void sort(int low, int mid, int high) {

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

    public void div(int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            div(low, mid);
            div(mid + 1, high);
            sort(low, mid, high);
        }
    }

    public void merge(int a[]) {
        this.arey = a;
        this.length = a.length;
        this.temp = new int[a.length];
        div(0, a.length - 1);
    }


}
