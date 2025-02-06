package dsa.array;

public class ThirdMaximumNumber414 {
    public static int thirdMax(int[] nums) {
        Integer first = null, second = null, third = null;

        for (int num : nums) {
            if (num == first || num == second || num == third) continue;

            if (first == null || num > first) {
                third = second;
                second = first;
                first = num;
            } else if (second == null || num > second) {
                third = second;
                second = num;
            } else if (third == null || num > third) {
                third = num;
            }
        }

        return third != null ? third : first;
    }

    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{3, 2, 1}));
        System.out.println(thirdMax(new int[]{1, 2}));
        System.out.println(thirdMax(new int[]{2, 2, 3, 1}));
    }
}
