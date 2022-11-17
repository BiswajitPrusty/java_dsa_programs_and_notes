package codingWithFolks;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.IntStream;

public class Day7 {


    static public int maxProfit(int[] prices) {

        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

    public int removeDuplicates(int[] nums) {
        IntStream a = Arrays.stream(nums).distinct();
        int b[] = a.toArray();
        for (int i = 0; i < b.length; i++) {
            nums[i] = b[i];
        }

        for (int i = b.length - 1; i < nums.length; i++) {

            nums[i] = 0;
        }

        return b.length;
    }
    public static void main(String[] args) {
        int a[] = {7, 1, 5, 3, 6, 4};
        maxProfit(a);
        Day7 d = new Day7();

    }


    public LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }


}
