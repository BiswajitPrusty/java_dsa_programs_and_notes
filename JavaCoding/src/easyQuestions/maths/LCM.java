package easyQuestions.maths;

public class LCM {

    public static void main(String[] args) {
        System.out.println(lcm1(4, 6));
    }

    public static int lcm(int a, int b) {
        int ans = a * b;
        //finding the gcd
        while (a != b) {
            if (a > b) a = a - b;
            else b = b - a;
        }
        //formula for finding lcm = (a * b)/(gcd(a,b))
        return ans / a;
    }

    //naive approach
    public static int lcm1(int a, int b) {
        int max = Math.max(a, b);
        while (true) {
            if( max % a == 0 && max % b == 0) break;
            max++;
        }
        return max;
    }
}
