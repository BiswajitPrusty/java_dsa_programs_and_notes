package easyQuestions.maths;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorialRecursive(5));
    }

    public static int factorialIterative(int nums) {
        int ans = 1;
        for (int i = 2; i <= nums; i++) {
            ans *= i;
        }
        return ans;
    }

    public static int factorialRecursive(int num) {
        if (num == 1) return 1;

        return factorialIterative(num - 1) * num;
    }
}
