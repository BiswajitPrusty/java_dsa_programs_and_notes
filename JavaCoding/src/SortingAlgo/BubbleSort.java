package SortingAlgo;

public class BubbleSort {

    public static void main(String[] args) {
        int a[] = {2, 1, 4, 3, 9, 5, 7, 8, 6};
        bubbleSort(a);
        for (int i : a) {
            System.out.print(i+", ");
        }
    }

    public static void bubbleSort(int a[]) {
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
