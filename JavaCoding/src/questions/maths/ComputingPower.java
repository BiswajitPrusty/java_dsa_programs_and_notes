package questions.maths;

public class ComputingPower {

    public static void main(String[] args) {
        power(2,3);
    }

    //naive approach
    public static int power(int x, int y) {
        int result = 1;
        for (int i = 0; i < y; i++) {
            result *= x;
        }
      return result;
    }
}
