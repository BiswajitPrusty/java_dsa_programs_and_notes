package questions.strings;

public class ExcelSheetColumnTitle168 {

    public static void main(String[] args) {
        System.out.println(convertToTitle(1));
    }

    public static String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder("");
        while (columnNumber > 0) {
            columnNumber--;
            int currentColumn = columnNumber % 26;
            columnNumber = columnNumber / 26;
            ans.append((char) ('A' + currentColumn));
        }
        return ans.reverse().toString();
    }
}
