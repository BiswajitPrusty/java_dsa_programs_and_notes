package questions.bitwise;

import java.util.ArrayList;
import java.util.List;

public class FindTwoOddAppearingNumbers {

    public static void main(String[] args) {
        findTwoOddNums(new int[]{1, 1, 2, 3, 3, 4, 4, 6});
    }

    public static void findTwoOddNums(int[] a) {
        int XOR = 0, num1 = 0, num2 = 0;

        for (int i : a) {
            XOR = XOR ^ i;
        }

        int lastBit = XOR & ~(XOR - 1);
        for (int i : a) {
            if ((lastBit & i) != 0) num1 = num1 ^ i;
            else num2 = num2 ^ i;

        }
        System.out.println(num1 + ", " + num2);
    }

    //my approach this methods work only if the last bits of two non repeating numbers are different
    public static void findTwoOddAppearingNumbers(int[] a) {
        int xorOfArray = 0;
        for (int i = 0; i < a.length; i++) {
            xorOfArray = xorOfArray ^ a[i];
        }
        List<Integer> group1 = new ArrayList<>();
        List<Integer> group2 = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if ((a[i] & 1) == 1) group1.add(a[i]);
            else group2.add(a[i]);
        }
        int first = printNonRepeatNumbers(group1);
        int second = printNonRepeatNumbers(group2);

    }

    public static int printNonRepeatNumbers(List<Integer> list) {
        int first = 0;
        for (int i : list) {
            first = first ^ i;
        }
        System.out.println(first);
        return first;
    }
}
