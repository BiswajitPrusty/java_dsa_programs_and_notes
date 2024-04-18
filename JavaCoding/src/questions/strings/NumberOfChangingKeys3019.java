package questions.strings;

public class NumberOfChangingKeys3019 {

    public static void main(String[] args) {
        System.out.println(countKeyChanges("aAbBcC"));
    }
    public static int countKeyChanges(String s) {
        char[] charArray = s.toLowerCase().toCharArray();
        int count = 0;
        for (int i = 0; i < charArray.length - 1; i++) {
            if (charArray[i] != charArray[i + 1]) {
                count++;
            }
        }
        return count;
    }
}
