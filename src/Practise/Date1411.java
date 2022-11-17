package Practise;

public class Date1411 {

    public static void main(String[] args) {

        int a[] = {9, 1, 4, 2, 3, 6, 8, 7, 0, 5};
        Date1411 d = new Date1411();
        d.selectionSort(a);
    }

    public void insertionSort(int a[]) {
        for (int i = 1; i < a.length; i++) {
            int j = i, temp = a[i];
            while (j > 0 && a[j - 1] > temp) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = temp;
        }
    }

    public void selectionSort(int a[]) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
        p(a);
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
        p(a);
    }

    public void p(int a[]) {
        for (int elements : a) {
            System.out.print(elements + ", ");
        }
    }
}
