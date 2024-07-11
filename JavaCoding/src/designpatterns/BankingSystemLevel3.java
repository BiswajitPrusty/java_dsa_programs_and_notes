package designpatterns;

import java.util.*;

public class BankingSystemLevel3 {
    static Map<String, Integer> accounts = new HashMap<>();
    static Map<String, Integer> transactionValues = new HashMap<>();
    static Map<String, Transfer> transfers = new HashMap<>();
    static int transferCount = 0;

    static List<String> processQueries(String[][] queries) {
        List<String> results = new ArrayList<>();

        for (String[] query : queries) {
            String operation = query[0];
            String timestamp = query[1];

            switch (operation) {
                case "CREATE_ACCOUNT":
                    String accountId = query[2];
                    results.add(createAccount(accountId));
                    break;
                case "DEPOSIT":
                    String accountIdDeposit = query[2];
                    int depositAmount = Integer.parseInt(query[3]);
                    results.add(deposit(timestamp, accountIdDeposit, depositAmount));
                    break;
                case "PAY":
                    String accountIdPay = query[2];
                    int paymentAmount = Integer.parseInt(query[3]);
                    results.add(pay(timestamp, accountIdPay, paymentAmount));
                    break;
                case "TRANSFER":
                    String sourceAccountId = query[2];
                    String targetAccountId = query[3];
                    int transferAmount = Integer.parseInt(query[4]);
                    results.add(transfer(timestamp, sourceAccountId, targetAccountId, transferAmount));
                    break;
                case "ACCEPT_TRANSFER":
                    String acceptAccountId = query[2];
                    String transferId = query[3];
                    results.add(acceptTransfer(timestamp, acceptAccountId, transferId));
                    break;
                case "TOP_ACTIVITY":
                    int n = Integer.parseInt(query[2]);
                    results.add(getTopActivity(n));
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
        if (!accounts.containsKey(accountId)) {
            accounts.put(accountId, 0);
            transactionValues.put(accountId, 0);
            return "true";
        } else {
            return "false";
        }
    }

    static String deposit(String timestamp, String accountId, int amount) {
        if (accounts.containsKey(accountId)) {
            int balance = accounts.get(accountId);
            balance += amount;
            accounts.put(accountId, balance);
            updateTransactionValue(accountId, amount);
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
                updateTransactionValue(accountId, -amount);
                return Integer.toString(balance);
            } else {
                return "";
            }
        } else {
            return "";
        }
    }

    static String transfer(String timestamp, String sourceAccountId, String targetAccountId, int amount) {
        if (!sourceAccountId.equals(targetAccountId) && accounts.containsKey(sourceAccountId) && accounts.containsKey(targetAccountId)) {
            int sourceBalance = accounts.get(sourceAccountId);
            if (sourceBalance >= amount) {
                String transferId = "transfer" + (++transferCount);
                Transfer transfer = new Transfer(transferId, timestamp, sourceAccountId, targetAccountId, amount);
                transfers.put(transferId, transfer);
                return transferId;
            } else {
                return "";
            }
        } else {
            return "";
        }
    }

    static String acceptTransfer(String timestamp, String accountId, String transferId) {
        if (transfers.containsKey(transferId)) {
            Transfer transfer = transfers.get(transferId);
            if (transfer.getTargetAccountId().equals(accountId)) {
                if (!transfer.isExpired(timestamp)) {
                    int amount = transfer.getAmount();
                    int sourceBalance = accounts.get(transfer.getSourceAccountId());
                    int targetBalance = accounts.get(transfer.getTargetAccountId());

                    sourceBalance -= amount;
                    targetBalance += amount;

                    accounts.put(transfer.getSourceAccountId(), sourceBalance);
                    accounts.put(transfer.getTargetAccountId(), targetBalance);

                    updateTransactionValue(transfer.getSourceAccountId(), -amount);
                    updateTransactionValue(transfer.getTargetAccountId(), amount);

                    transfers.remove(transferId);
                    return "true";
                }
            }
        }
        return "false";
    }

    static void updateTransactionValue(String accountId, int amount) {
        int value = transactionValues.get(accountId);
        value += amount;
        transactionValues.put(accountId, value);
    }

    static String getTopActivity(int n) {
        Map<String, Integer> transactionValuesCopy = new HashMap<>(transactionValues);

        List<Map.Entry<String, Integer>> sortedAccounts = new ArrayList<>(transactionValuesCopy.entrySet());
        sortedAccounts.sort((a, b) -> {
            int compare = Integer.compare(b.getValue(), a.getValue());
            return compare != 0 ? compare : a.getKey().compareTo(b.getKey());
        });

        StringBuilder result = new StringBuilder();
        int limit = Math.min(n, sortedAccounts.size());
        for (int i = 0; i < limit; i++) {
            Map.Entry<String, Integer> entry = sortedAccounts.get(i);
            result.append(entry.getKey()).append("(").append(entry.getValue()).append(")");
            if (i < limit - 1) {
                result.append(", ");
            }
        }

        return result.toString();
    }

    static class Transfer {
        private String transferId;
        private String timestamp;
        private String sourceAccountId;
        private String targetAccountId;
        private int amount;

        public Transfer(String transferId, String timestamp, String sourceAccountId, String targetAccountId, int amount) {
            this.transferId = transferId;
            this.timestamp = timestamp;
            this.sourceAccountId = sourceAccountId;
            this.targetAccountId = targetAccountId;
            this.amount = amount;
        }

        public String getTransferId() {
            return transferId;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public String getSourceAccountId() {
            return sourceAccountId;
        }

        public String getTargetAccountId() {
            return targetAccountId;
        }

        public int getAmount() {
            return amount;
        }

        public boolean isExpired(String currentTimestamp) {
            long diff = Long.parseLong(currentTimestamp) - Long.parseLong(timestamp);
            return diff >= 86400000;
        }
    }

    public static void main(String[] args) {
        String[][] queries = {{"CREATE_ACCOUNT", "1", "account1"},
                {"CREATE_ACCOUNT", "2", "account2"},
                {"CREATE_ACCOUNT", "3", "account3"},
                {"DEPOSIT", "4", "account1", "1000"},
                {"DEPOSIT", "5", "account2", "1100"},
                {"DEPOSIT", "6", "account3", "1200"},
                {"TRANSFER", "7", "account2", "account1", "300"},
                {"TOP_ACTIVITY", "8", "3"},
                {"ACCEPT_TRANSFER", "9", "account1", "transfer1"},
                {"TOP_ACTIVITY", "10", "3"}};
        List<String> results = processQueries(queries);
        for (String result : results) {
            System.out.println(result);
        }
    }
}
