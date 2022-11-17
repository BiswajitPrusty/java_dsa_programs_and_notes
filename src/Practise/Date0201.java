package Practise;

public class Date0201 {

    public static void main(String[] args) {
        int[] a = {9, 1, 8, 3, 7, 2, 5, 0, 4, 6};

        Date0201 d = new Date0201();
//        d.quick(a,0,a.length-1);

        boolean b = 1==2 || 2==2 || 3==1;
        System.out.println(b);
//        for (int i : a) {
//            System.out.print(i + ", ");
//        }
    }

    public void quick(int a[], int low, int high) {
        int p = quickSort(a, low, high);
        if (low < p - 1)
            quick(a, low, p - 1);

        if (high > p)
            quick(a, p, high);

    }

    public int quickSort(int a[], int low, int high) {
        int pi = a[(low + high) / 2];
        while (low <= high) {
            if (a[low] < pi) {
                low++;
            }

            if (a[high] > pi) {
                high--;
            }

            if (low <= high) {
                int temp = a[low];
                a[low] = a[high];
                a[high] = temp;
                high--;
                low++;
            }
        }
        return low;
    }


    public void mergeSort(int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            temp[i] = arey[i];
        }
        int i = low, j = mid + 1, k = low;
        while (i <= mid && j <= high) {
            if (temp[i] < temp[j])
                arey[k++] = temp[i++];
            else
                arey[k++] = temp[j++];
        }
        while (i <= mid) {
            arey[k++] = temp[i++];

        }
    }

    public void divide(int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            divide(low, mid);
            divide(mid + 1, high);
            mergeSort(low, mid, high);
        }
    }

    int[] arey;
    int[] temp;

    public void merge(int[] a) {
        this.arey = a;
        this.temp = new int[a.length];
        divide(0, a.length - 1);
    }
}
