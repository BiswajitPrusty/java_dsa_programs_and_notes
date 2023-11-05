package questions.arrays;

public class AverageValueOfEvenNumbers2455 {

    public static void main(String[] args) {
        System.out.println(averageValue(new int[]{1, 2, 4, 7, 10}));
    }

    public static int averageValue(int[] nums) {
        int count = 0, sum = 0;

        for (int num : nums) {
            if (num % 2 == 0 && num % 3 == 0) {
                count++;
                sum += num;
            }
        }
        if (count == 0)
            return count;
        else
            return sum / count;
    }
}
