package questions.strings;

public class DeleteColumns944 {

    public static void main(String[] args) {
        System.out.println(minDeletionSize(new String[]{"a","b"}));
    }

    public static int minDeletionSize(String[] strs) {
        int countToDelete = 0;
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length() - 1; j++) {
                if (strs[j].charAt(i) > strs[j + 1].charAt(i)) {
                    countToDelete++;
                    break;
                }
            }
        }
        return countToDelete;
    }
}
