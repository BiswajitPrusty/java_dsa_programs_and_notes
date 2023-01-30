package questions.bitwise;

public class PowerOfFour {

    public static void main(String[] args) {
        System.out.println(powerOfFour(2));
    }

    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num - 1) % 3 == 0;
    }

    /*
    1 2 4 8 16 32 64 128 256 592 1084 ...... -> This All Are Power Of Two [ Mean Having Only One Set Bit ]
    1 4 16 64 256 1084......-> This All Are Power Of Four , Now We can Greedly Observe
    That Between two power_of_4 there Was One Invaild Power_Of_4 Exist
    So we need To check that Condition Too
     */
    public static boolean powerOfFour(int num) {
        if (num < 0) return false;

        for (int i = 0; i < 32; i += 2) {
            int leftShift = 1 << i;
            if (num == leftShift)
                return true;
        }
        return false;
    }
}
