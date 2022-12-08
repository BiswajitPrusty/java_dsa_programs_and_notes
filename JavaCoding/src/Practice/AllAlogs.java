package Practice;

public class AllAlogs {

    public static void main(String[] args) {

        AllAlogs algo = new AllAlogs();
        int a[] = {9, 1, 4, 3, 2, 6, 5, 8, 7};
        algo.bubbleSort(a);


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
        printArray(a);
    }

    public void selectionSort(int a[]) {

    }

    public void insertionSort(int a[]) {

    }

    public void mergeSort() {

    }

    public void quickSort() {

    }

    public void printArray(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+", ");
        }
        System.out.println();
    }


}
