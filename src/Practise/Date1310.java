package Practise;

public class Date1310 {

    public static void main(String[] args) {

        Date1310 d = new Date1310();

        int[] a = {9, 7, 3, 1, 4, 2, 5, 6, 8};

        d.selectionSort(a);
    }

    public void insertionSort(int a[]) {
        for (int i = 0; i < a.length; i++) {
            int j = i;
            int temp = a[i];

        }
    }

    public void selectionSort(int a[]) {

        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i; j < a.length; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
        printList(a);
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
        printList(a);
    }

    public void printList(int a[]) {
        for (int num : a) {
            System.out.print(num + ", ");
        }
        System.out.println();
    }
}
