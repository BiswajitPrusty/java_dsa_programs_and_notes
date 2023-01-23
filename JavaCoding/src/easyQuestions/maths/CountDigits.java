package easyQuestions.maths;

public class CountDigits {

    public static void main(String[] args) {
        System.out.println(countDigits(111));
    }
    public static int countDigits(int num) {
        int counter = 0;
        while (num > 0) {
            counter++;
            num /= 10;
        }
        return counter;
    }
}
