package designpatterns;

import java.util.*;

public class BankingSystem {
    static Map<String, Integer> accounts = new HashMap<>();

    static List<String> processQueries(String[][] queries) {
        List<String> results = new ArrayList<>();

        for (String[] query : queries) {
            String operation = query[0];
            String timestamp = query[1];
            String accountId = query[2];

            switch (operation) {
                case "CREATE_ACCOUNT":
                    results.add(createAccount(accountId));
                    break;
                case "DEPOSIT":
                    int depositAmount = Integer.parseInt(query[3]);
                    results.add(deposit(timestamp, accountId, depositAmount));
                    break;
                case "PAY":
                    int paymentAmount = Integer.parseInt(query[3]);
                    results.add(pay(timestamp, accountId, paymentAmount));
                    break;
                default:
                    // Unsupported operation
                    results.add("");
                    break;
            }
        }

        return results;
    }

    static String createAccount(String accountId) {
        if (accounts.containsKey(accountId)) {
            return "false";
        } else {
            accounts.put(accountId, 0);
            return "true";
        }
    }

    static String deposit(String timestamp, String accountId, int amount) {
        if (accounts.containsKey(accountId)) {
            int balance = accounts.get(accountId);
            balance += amount;
            accounts.put(accountId, balance);
            return Integer.toString(balance);
        } else {
            return "";
        }
    }

    static String pay(String timestamp, String accountId, int amount) {
        if (accounts.containsKey(accountId)) {
            int balance = accounts.get(accountId);
            if (balance >= amount) {
                balance -= amount;
                accounts.put(accountId, balance);
                return Integer.toString(balance);
            } else {
                return "";
            }
        } else {
            return "";
        }
    }

    public static void main(String[] args) {
        String[][] queries = {
                {"CREATE_ACCOUNT", "1", "account1"},
                {"CREATE_ACCOUNT", "2", "account2"},
                {"CREATE_ACCOUNT", "3", "account2"},
                {"DEPOSIT", "4", "non-existing", "2700"},
                {"DEPOSIT", "5", "account1", "2700"},
                {"PAY", "6", "non-existing", "2700"},
                {"PAY", "7", "account1", "2701"},
                {"PAY", "8", "account1", "200"}
        };

        List<String> results = processQueries(queries);
        String[] ans = new String[results.size()];
        int i = 0;
        for (String result : results) {
            ans[i++] = result;
            System.out.println(result);
        }
    }
}
