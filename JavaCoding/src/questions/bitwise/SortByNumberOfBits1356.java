package questions.bitwise;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortByNumberOfBits1356 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortByBitsAlgorithm(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8})));
    }

    /*
    Input: arr = [0,1,2,3,4,5,6,7,8]
    Output: [0,1,2,4,8,3,5,6,7]
    Explantion: [0] is the only integer with 0 bits.
    [1,2,4,8] all have 1 bit.
    [3,5,6] have 2 bits.
    [7] has 3 bits.
    The sorted array by bits is [0,1,2,4,8,3,5,6,7]

     */
    public static int[] sortByBitsAlgorithm(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                int bitCountA = Integer.bitCount(arr[j]);
                int bitCountB = Integer.bitCount(arr[j + 1]);
                if (bitCountA > bitCountB || (bitCountA == bitCountB && arr[j] > arr[j + 1])) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] sortByBitsNotAlgorithm(int[] arr) {
        Map<Integer, Integer> bitCount = new TreeMap<>();
        for (int num : arr) {
            int count = 0, temp = num;
            while (temp > 0) {
                temp = (temp & (temp - 1));
                count++;
            }
            bitCount.put(num, count);
        }
        Map<Integer, List<Map.Entry<Integer, Integer>>> collect = bitCount.entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getValue));
        int index = 0;
        for (Map.Entry<Integer, List<Map.Entry<Integer, Integer>>> entries : collect.entrySet()) {
            List<Map.Entry<Integer, Integer>> value = entries.getValue();
            for (int i = 0; i < value.size(); i++) {
                arr[index++] = value.get(i).getKey();
            }
        }
        return arr;
    }
}
