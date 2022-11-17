package Practise;

public class Date2612 {

    public static void main(String[] args) {
        int a[] = {9, 1, 8, 2, 7, 3, 6, 5, 0, 4};

        Date2612 d = new Date2612();
//        d.insert(a);
//        for (int i : a) {
//            System.out.print(i + ", ");
//        }
        d.star();
    }

    void star() {
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    void insert(int a[]) {
        for (int i = 1; i < a.length; i++) {
            int j = i, temp = a[i];
            while (j > 0 && a[j - 1] > temp) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = temp;
        }
    }

    void selection(int a[]) {
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

    void bubbleSort(int a[]) {
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
}
