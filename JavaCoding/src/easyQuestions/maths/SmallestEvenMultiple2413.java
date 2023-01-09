package easyQuestions.maths;

public class SmallestEvenMultiple2413 {
    public static void main(String[] args) {
        System.out.println(smallestEvenMultiple(6));
    }

    public static int smallestEvenMultiple1(int n) {

        return n % 2 == 0 ? n : n * 2;
    }

    public static int smallestEvenMultiple(int n) {
        int result = 0;
        for (int i = 1; i <= 10; i++) {
            int multi = n * i;
            if (multi % 2 == 0) {
                return multi;
            }
        }
        return -1;

    }
}
