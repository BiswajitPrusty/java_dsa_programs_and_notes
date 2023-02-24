package questions.bitwise;

public class MinimumBitFlipsToConvertNumber2220 {

    /*
We need to count the number of corresponding bits of start and goal that are different.
xor-ing start and goal will result in a new number with binary representation of 0 where the
corresponding bits of start and goal are equal and 1 where the corresponding bits are different.

For example: 10 and 7
10 = 1010
7 = 0111

10 xor 7 = 1101 (3 ones)

Next we need to count the number of 1s (different bits)
The quickest way to count the number of 1s in a number is by eliminating the right most 1 each time and count
the number of eliminations, this is done by and-ing the number with (number-1)
Subtracting a 1 from a number flips all right most bits until the first right most 1 and by and-ing with the number
itself we eliminating the all bits until the first tight most 1 (inclusive)
ex.
number =1101
number -1 = 1100
number and (number -1) = 1100 (we eliminated the right most 1)
     */
    public int minBitFlips(int start, int goal) {
        int xor = start ^ goal;
        int count = 0;
        while(xor > 0){
            xor = xor & (xor -1);
            count++;
        }
        return count;
    }
}
