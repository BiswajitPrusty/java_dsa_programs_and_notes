package questions.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class OnlineStockSpan901 {


   static Deque<int[]> stack = new ArrayDeque<>();

    public static void main(String[] args) {
        int arr[] = {100, 80, 60, 70, 60, 75, 85};
        for (int i : arr) {
            stockSpan(i);

        }
    }

    public static int stockSpan(int price) {
        int res = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price)
            res += stack.pop()[1];
        stack.push(new int[]{price, res});
        return res;
    }

    public static void printStockSpan3(int... arr) {
        Deque<Integer> s = new ArrayDeque<>();
        s.push(0);
        System.out.println(1);
        int span = 0;
        for (int i = 1; i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            span = s.isEmpty() ? i + 1 : i - s.peek();
            System.out.println(span);
            s.push(i);
        }
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
