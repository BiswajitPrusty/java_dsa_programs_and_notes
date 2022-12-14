package Practice;

public class AllAlogs {

    public static void main(String[] args) {

        AllAlogs algo = new AllAlogs();
        int a[] = {9, 1, 4, 3, 2, 6, 5, 8, 7};
        algo.insertionSort(a);

        printArray(a);

    }

    public static void printArray(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println();
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
    }

    public void selectionSort(int a[]) {

        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {

                if (a[j] < a[min]) {
                    min = j;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }

    public void insertionSort(int a[]) {
//        int a[] = {9, 1, 4, 3, 2, 6, 5, 8, 7};

        int temp, j;
        for (int i = 1; i < a.length; i++) {
            temp = a[i];
            j = i;

            while (j > 0 && temp < a[j - 1]) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = temp;
        }
    }

    public void mergeSort() {


    }

    public void quickSort() {

    }


}
