package SortingAlgo;

public class SelectionSort {

    public static void main(String[] args) {
        int a[] = {2, 1, 4, 3, 9, 5, 7, 8, 6};
        selection(a);
        for (int i : a) {
            System.out.print(i+", ");
        }
    }

    public static void selection(int a[]) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            int temp = a[min];
            a[min] = a[i];
            a[i] = temp;

        }
    }
}
