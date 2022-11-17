package SortingAlgo;

public class InsertionSort {

    public static void main(String[] args) {
        int a[] = {2, 1, 4, 3, 9, 5, 7, 8, 6};
        insert(a);
        for (int i : a) {
            System.out.print(i + ", ");
        }
    }

    public static void insert(int a[]) {
        for (int i = 1; i < a.length; i++) {
            int j = i, temp = a[i];//1
            while (j > 0 && a[j - 1] > temp) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = temp;
        }

    }
}
