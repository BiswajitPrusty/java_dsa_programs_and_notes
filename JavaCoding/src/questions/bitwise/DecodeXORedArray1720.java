package questions.bitwise;

public class DecodeXORedArray1720 {

    /*
     Input: encoded = [1,2,3], first = 1
     Output: [1,0,2,1]
     Explanation: If arr = [1,0,2,1], then first = 1 and encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]
     */

    public static void main(String[] args) {
        System.out.println(decode(new int[]{1, 2, 3}, 1));
    }

    //online solution with O(n)
    public static int[] decode2(int[] encoded, int first) {
        int[] a = new int[encoded.length + 1];
        a[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            a[i + 1] = a[i] ^ encoded[i];
        }
        return a;
    }
    //my first approach with O(N+N)
    public static int[] decode(int[] encoded, int first) {

        int[] a = new int[encoded.length + 1];
        a[0] = first;
        for (int i = 1; i <= encoded.length; i++) {
            a[i] = encoded[i - 1];
        }
        for (int i = 0; i < a.length - 1; i++) {
            a[i + 1] = a[i] ^ a[i + 1];
        }
        return a;
    }
}
