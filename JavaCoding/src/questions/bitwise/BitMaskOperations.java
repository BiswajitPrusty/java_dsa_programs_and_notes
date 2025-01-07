package questions.bitwise;

public class BitMaskOperations {

    public static void main(String[] args) {
        maskBit(new int[]{0,1,2,1,0,3},new int[]{1,1,1,2,3,4}, 5);
    }
    /*
    1 X: means print value of Xth bit in N. (value can be 0 or 1)
    2 X: means change Xth bit of N to 1, and then print N.
    3 X: means change Xth bit of N to 0 , and then print N.
    4 X: means toggle Xth bit of N and then print N, toggle means change 0 to 1
    output: 1,0,1,7,6,14
     */
    public static void maskBit(int[] xthBit, int[] operations, int n) {
        for (int i = 0; i < operations.length; i++) {
            int position = xthBit[i];
            int operation = operations[i];
            switch (operation) {
                case 1:
                    System.out.println((n & (1 << (position - 1))) == 0 ? 1 : 0);
                    break;
                case 2:
                    System.out.println();
            }
        }
    }
}
