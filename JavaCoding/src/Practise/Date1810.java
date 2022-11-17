package Practise;

public class Date1810 {

    public static void main(String[] args) {
        int a[] = {9, 1, 4, 2, 3, 0, 8, 7, 6, 5};

        Date1810 d = new Date1810();
        d.heapSort(a);
        for(int i:a)
        System.out.print(i+" ");
    }


    public void heapSort(int a[]) {
        int len = a.length;
        for (int i = len / 2 -1; i >= 0; i--) {

            heapify(a, len, i);
        }

        for (int i = len-1; i >= 0; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            heapify(a, i, 0);
        }
    }

    public void heapify(int a[], int al, int pi) {
        int large = pi;
        int rn = 2 * pi + 2;
        int ln = 2 * pi + 1;
        if (rn < al && a[rn] > a[large]) {
            large = rn;
        }

        if (ln < al && a[ln] > a[large]) {
            large = ln;
        }
        if (pi != large) {
            int temp = a[pi];
            a[pi] = a[large];
            a[large] = temp;
            heapify(a, al, large);
        }
    }
}
