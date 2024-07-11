package questions.strings;

public class DeleteColumns944 {

    public static void main(String[] args) {
        System.out.println(minDeletionSize(new String[]{"rrjk", "furt", "guzm"}));
    }

    public static int minDeletionSize(String[] strs) {
        int row = strs.length;
        int col = strs[0].length();
        int ans = 0;

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row - 1; j++) {
                if (strs[j].charAt(i) > strs[j + 1].charAt(i)) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
