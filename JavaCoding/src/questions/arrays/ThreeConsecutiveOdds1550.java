package questions.arrays;

public class ThreeConsecutiveOdds1550 {

    public static void main(String[] args) {
        System.out.println(threeConsecutiveOdds(new int[]{1,2,34,3,4,5,7,23,12}));
    }
    public static boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num % 2 != 0) {
                count++;
                if (count == 3) {
                    return true;
                }
            }else{
                count = 0;
            }
        }
        return false;
    }
}
