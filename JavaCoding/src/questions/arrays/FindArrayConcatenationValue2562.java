package questions.arrays;

public class FindArrayConcatenationValue2562 {

    public static void main(String[] args) {
        System.out.println(findTheArrayConcVal(7, 52, 2, 4));
    }
    public static long findTheArrayConcVal(int... nums) {
        long ans = 0;
        int low = 0, high = nums.length -1;
        String concat = "";
        while (low < high) {
            concat = nums[low++] + "" + nums[high--];
            ans += Long.valueOf(concat);
        }
        if(nums.length % 2 != 0){
            ans += nums[nums.length / 2];
        }
        return ans;
    }
}
