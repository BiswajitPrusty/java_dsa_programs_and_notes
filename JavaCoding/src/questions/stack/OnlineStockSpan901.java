package questions.stack;

public class OnlineStockSpan901 {

    public int next(int price) {

        return 1;
    }

    public static void main(String[] args) {
        printStockSpan(30, 20, 25, 28, 27, 29);
    }

    //naive approach
    public static void printStockSpan(int... arr) {
        for (int i = 0; i < arr.length; i++) {
            int span = 1;
            for (int j = i - 1; j >= 0 && arr[i] >= arr[j]; j--) {
                span++;
            }
            System.out.println(span);
        }
    }
}
