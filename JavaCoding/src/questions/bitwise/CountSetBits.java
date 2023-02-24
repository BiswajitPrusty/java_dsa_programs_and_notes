package questions.bitwise;

public class CountSetBits {

    public static void main(String[] args) {
        System.out.println(countSetBits3(13));
    }

    //little efficient approach, tc = theta of number of set bits in number
    public static int countSetBits3(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    //naive approach time complexity is number size of bits
    public static int countSetBits2(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n = n >> 1;
        }
        return count;
    }

    //my approach
    public static int countSetBits(int n) {
        int count = 0;
        for (int i = 1; i <= 32; i++) {
            if ((n & 1) == 1) count++;
            n = n >> 1;
        }
        return count;
    }
}
