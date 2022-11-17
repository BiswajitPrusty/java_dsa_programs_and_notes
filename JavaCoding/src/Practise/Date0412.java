package Practise;

public class Date0412 {

    public static void main(String[] args) {

        int a[] = {9, 1, 3, 2};
        Date0412 d = new Date0412();
        d.mergeSort(a);


        d.primeCheck(1);
    }

    public void primeCheck(int n) {
        int i = 2;
        boolean prime = true;
        while (i <= Math.sqrt(n)) {
            if (n % i == 0) {
                prime = false;
                break;
            } else
                prime = true;

            i++;
        }
        if (prime) {
            System.out.println(n + " is prime number");
        } else
            System.out.println(n + " is not prime");
    }

    private int length;
    private int temp[];
    private int arey[];

    private void merging(int low, int mid, int high) {
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

    private void mergeDiv(int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeDiv(low, mid);
            mergeDiv(mid + 1, high);
            merging(low, mid, high);
        }
    }

    private void mergeSort(int a[]) {

        this.arey = a;
        this.length = a.length;
        this.temp = new int[a.length];
        mergeDiv(0, this.length - 1);
    }

    private void heapCall(int a[]) {
        int len = a.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(a, len, i);
        }

        for (int i = len - 1; i >= 0; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            heapify(a, i, 0);
        }
    }

    private void heapify(int a[], int al, int pn) {
        int big = pn;
        int ln = 2 * pn + 1;
        int rn = 2 * pn + 2;

        if (ln < al && a[ln] > a[big]) {
            big = ln;
        }
        if (rn < al && a[rn] > a[big]) {
            big = rn;
        }
        if (pn != big) {
            int temp = a[pn];
            a[pn] = a[big];
            a[big] = temp;
            heapify(a, al, big);
        }
    }


    private void quickSort(int a[], int low, int high) {
        int pi = quickdivide(a, low, high);
        System.out.println(low + " < " + (pi - 1));
        if (low < pi - 1) {
            quickdivide(a, low, pi - 1);
        }
        if (high > pi) {
            System.out.println("in side");
            quickdivide(a, pi, high);
        }
    }

    private int quickdivide(int a[], int low, int high) {
        int pivot = a[(low + high) / 2];
        while (low <= high) {
            while (a[low] < pivot) {
                low++;
            }
            while (a[high] > pivot) {
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

    private void print(int a[]) {
        for (int i : a) {
            System.out.print(i + ", ");
        }
    }

}
