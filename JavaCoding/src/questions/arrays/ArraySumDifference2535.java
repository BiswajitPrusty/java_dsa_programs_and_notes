package questions.arrays;

public class ArraySumDifference2535 {

    public static void main(String[] args) {
        differenceOfSum(new int[]{1,15,6,3});
    }
    public static int differenceOfSum(int[] nums) {
        int sumOfArray = 0;
        int sumOfFirstChar = 0;
        for(int i = 0; i < nums.length; i++){
            sumOfArray +=nums[i];
            String firstNumber = nums[i] + "";
            sumOfFirstChar += Integer.valueOf(String.valueOf(firstNumber.charAt(0)));
        }

        return sumOfArray - sumOfFirstChar;
    }
}
