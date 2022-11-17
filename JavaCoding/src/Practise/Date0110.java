package Practise;

public class Date0110 {

    int arey[];
    int length;
    int temp[];


    public static void main(String[] args) {
        int a[] = {3, 2, 1, 6, 4, 0, 8, 9, 5, 7};

        Date0110 d = new Date0110();
        d.merg(a);
        for (int i : a) {
            System.out.print(i + " ");
        }

    }

    public void merging(int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            temp[i] = arey[i];
        }
        int i = low, j = mid + 1, k = low;
        while (i <= mid && j <= high) {
            if (temp[i] < temp[j]) {
                arey[k++] = temp[i++];
            } else {
                arey[k++] = temp[j++];
            }
        }

        while (i <= mid) {
            arey[k++] = temp[i++];
        }
    }

    public void merg(int a[]) {
        arey = a;
        temp = new int[a.length];
        mergeDivide(0, a.length - 1);
    }

    public void mergeDivide(int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeDivide(low, mid);
            mergeDivide(mid + 1, high);
            merging(low, mid, high);
        }
    }
}
