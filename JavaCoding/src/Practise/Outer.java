package Practise;

public class Outer {
    static int data = 30;

    static class Inner {
        static void msg() {
            System.out.println("data is " + data);
        }
    }

    public static void main(String args[]) {
        Outer.Inner.msg();//no need to create the instance of static nested class
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = arr.length;
        int sum = 15;
        subArraySum(arr, n, sum);
    }

    public static String subArraySum(int a[], int size, int sum) {
        int i, j;
        for (i = 0; i < a.length; i++) {
            int total = a[i];
            for (j = i + 1; j < a.length; j++) {
                if (total == sum) {
                    System.out.println("index is at " + i + " and " + (j - 1));
                    return "found";
                }
                if (total > sum || j == a.length) {
                    break;
                }
                total += a[j];
            }
        }
        return "not found";
    }
}
