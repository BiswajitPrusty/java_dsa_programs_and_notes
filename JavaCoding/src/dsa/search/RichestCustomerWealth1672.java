package dsa.search;

public class RichestCustomerWealth1672 {

    public int maximumWealth(int[][] accounts) {
        int maxMoney = 0;

        for (int[] account : accounts) {
            int sum = 0;
            for (int i = 0; i < account.length; i++) {
                sum += account[i];
            }
            if (sum > maxMoney) {
                maxMoney = sum;
            }
        }

        return maxMoney;
    }
}
