package Practise;

public class Date0101 {

    public static void main(String[] args) {
        int a[] = {9, 1, 3, 2, 7, 5, 6, 4, 8, 0};
        insertion(a);

        for (int i : a)
            System.out.print(i + ", ");
    }

    public static void insertion(int a[]) {
        for (int i = 1; i < a.length; i++) {
            int j = i, temp = a[i];
            while (j > 0 && a[j - 1] > temp) {
                a[j] = a[j-1];
                j--;
            }
            a[j] = temp;

        }
    }

    public static void selection(int a[]) {
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
    }

    public static void bubble(int a[]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }

        }
    }
}
