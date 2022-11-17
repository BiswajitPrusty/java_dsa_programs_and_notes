package Practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Date2609 {

    public static void main(String[] args) {
        countingSort(Arrays.asList(1, 1, 3, 2, 1));

    }

    public static List<Integer> countingSort(List<Integer> arr) {
        List<Integer> result = new ArrayList<Integer>();
        int[] frequency = new int[100];
        for (Integer each : arr){
            System.out.println(each);
            frequency[each] += 1;

        }
        for (int each : frequency)
            result.add(each);
        System.out.println(result);
        return result;
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        Integer lsum = 0, rsum = 0;
        int leng = arr.size();
        for (int i = 0; i < leng; i++) {
            lsum += arr.get(i).get(i);
            rsum += arr.get(leng - (1 + i)).get(i);
        }
        return Math.abs(lsum - rsum);
    }

    public static int lonelyinteger(List<Integer> a) {
        // Write your code here
        for (int i = 0; i < a.size(); i++) {
            int count = 0;

            for (int j = 0; j < a.size(); j++) {

                if (a.get(i) == a.get(j)) {
                    count++;
                    if (count == 2) {
                        break;
                    }
                }
            }

            if (count == 1) {
                System.out.println(a.get(i));
                return a.get(i);
            }
        }
        return 0;
    }
}
